package io.zenwave360.example.delivery.adapters.web;

import io.zenwave360.example.delivery.adapters.web.mappers.*;
import io.zenwave360.example.delivery.adapters.web.model.*;
import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.inbound.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

/** REST controller for DeliveryApi. */
@RestController
@RequestMapping("/api")
public class DeliveryApiController implements DeliveryApi {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired private NativeWebRequest request;

  private DeliveryService deliveryService;

  @Autowired
  public DeliveryApiController setDeliveryService(DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
    return this;
  }

  private DeliveryDTOsMapper mapper = DeliveryDTOsMapper.INSTANCE;

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<DeliveryDTO> updateDeliveryStatus(String orderId, DeliveryStatusInputDTO reqBody) {
    var input = mapper.asDeliveryStatusInput(reqBody);
    var delivery = deliveryService.updateDeliveryStatus(orderId, input);
    DeliveryDTO responseDTO = mapper.asDeliveryDTO(delivery);
    return ResponseEntity.status(200).body(responseDTO);
  }

  @Override
  public ResponseEntity<DeliveryPaginatedDTO> listDeliveries(Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort) {
    var deliveryPage = deliveryService.listDeliveries(pageOf(page, limit, sort));
    var responseDTO = mapper.asDeliveryPaginatedDTO(deliveryPage);
    return ResponseEntity.status(200).body(responseDTO);
  }

  protected Pageable pageOf(Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort) {
    return PageRequest.of(page.orElse(0), limit.orElse(10));
  }
}
