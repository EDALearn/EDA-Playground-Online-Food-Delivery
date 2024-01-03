package io.zenwave360.example.config;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        if (ex instanceof ErrorResponse errorResponse) {
            ProblemDetail body = errorResponse.updateAndGetBody(getMessageSource(), LocaleContextHolder.getLocale());
            if(ex instanceof MethodArgumentNotValidException errors) {
                fillBindingErrors(body, errors);
            }
            return this.createResponseEntity(body, headers, statusCode, request);
        }
        return super.handleMethodArgumentNotValid(ex, headers, statusCode, request);
    }

    private void fillBindingErrors(ProblemDetail body, MethodArgumentNotValidException errors) {
        errors.getBindingResult().getGlobalErrors().forEach(fieldError -> {
            body.setProperty(fieldError.getObjectName(), fieldError.toString());
        });
        errors.getBindingResult().getFieldErrors().forEach(fieldError -> {
            body.setProperty(fieldError.getObjectName() + "." + fieldError.getField(), fieldError.getDefaultMessage());
        });
    }
}
