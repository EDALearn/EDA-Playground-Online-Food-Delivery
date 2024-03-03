package io.zenwave360.example.orders.adapters.web;

import io.zenwave360.example.orders.adapters.web.mappers.*;
import io.zenwave360.example.orders.adapters.web.model.*;
import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import java.math.*;
import java.time.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

/** REST controller for OrdersApi. */
@RestController
@RequestMapping("/api")
public class OrdersApiController implements OrdersApi {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired private NativeWebRequest request;

  private OrdersService ordersService;

  @Autowired
  public OrdersApiController setOrdersService(OrdersService ordersService) {
    this.ordersService = ordersService;
    return this;
  }

  private OrdersDTOsMapper mapper = OrdersDTOsMapper.INSTANCE;

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<CustomerOrderDTO> getCustomerOrder(String orderId) {
    var customerOrder = ordersService.getCustomerOrder(orderId);
    if (customerOrder.isPresent()) {
      CustomerOrderDTO responseDTO = mapper.asCustomerOrderDTO(customerOrder.get());
      return ResponseEntity.status(200).body(responseDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<CustomerOrderDTO> updateOrder(String orderId, CustomerOrderInputDTO reqBody) {
    var input = mapper.asCustomerOrderInput(reqBody);
    var customerOrder = ordersService.updateOrder(orderId, input);
    CustomerOrderDTO responseDTO = mapper.asCustomerOrderDTO(customerOrder);
    return ResponseEntity.status(200).body(responseDTO);
  }

  @Override
  public ResponseEntity<CustomerOrderDTO> createOrder(CustomerOrderInputDTO reqBody) {
    var input = mapper.asCustomerOrderInput(reqBody);
    var customerOrder = ordersService.createOrder(input);
    CustomerOrderDTO responseDTO = mapper.asCustomerOrderDTO(customerOrder);
    return ResponseEntity.status(201).body(responseDTO);
  }

  @Override
  public ResponseEntity<CustomerOrderDTO> cancelOrder(String orderId, CancelOrderInputDTO reqBody) {
    var input = mapper.asCancelOrderInput(reqBody);
    var customerOrder = ordersService.cancelOrder(orderId, input);
    CustomerOrderDTO responseDTO = mapper.asCustomerOrderDTO(customerOrder);
    return ResponseEntity.status(200).body(responseDTO);
  }

  @Override
  public ResponseEntity<List<CustomerOrderDTO>> searchOrders(OrdersFilterDTO reqBody) {
    var input = mapper.asOrdersFilter(reqBody);
    var customerOrder = ordersService.searchOrders(input);
    var responseDTO = mapper.asCustomerOrderDTOList(customerOrder);
    return ResponseEntity.status(201).body(responseDTO);
  }

  protected Pageable pageOf(Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort) {
    return PageRequest.of(page.orElse(0), limit.orElse(10));
  }
}
