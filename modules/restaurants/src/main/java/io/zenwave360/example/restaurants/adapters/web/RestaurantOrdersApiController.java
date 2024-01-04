package io.zenwave360.example.restaurants.adapters.web;

import io.zenwave360.example.restaurants.adapters.web.mappers.*;
import io.zenwave360.example.restaurants.adapters.web.model.*;
import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

/** REST controller for Api. */
@RestController
@RequestMapping("/api")
public class RestaurantOrdersApiController implements RestaurantOrdersApi {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired private NativeWebRequest request;

  private RestaurantOrdersService restaurantOrdersService;

  @Autowired
  public RestaurantOrdersApiController setRestaurantOrdersService(RestaurantOrdersService restaurantOrdersService) {
    this.restaurantOrdersService = restaurantOrdersService;
    return this;
  }

  private RestaurantOrdersDTOsMapper mapper = RestaurantOrdersDTOsMapper.INSTANCE;

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<KitchenOrderDTO> updateKitchenOrderStatus(String orderId, KitchenOrderStatusInputDTO reqBody) {
    KitchenOrderStatusInput input = mapper.asKitchenOrderStatusInput(reqBody);
    KitchenOrder kitchenOrder = restaurantOrdersService.updateKitchenOrderStatus(orderId, input);
    KitchenOrderDTO responseDTO = mapper.asKitchenOrderDTO(kitchenOrder);
    return ResponseEntity.status(200).body(responseDTO);
  }

  @Override
  public ResponseEntity<KitchenOrderPaginatedDTO> searchKitchenOrders(Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort, KitchenOrdersFilterDTO kitchenOrdersFilterDTO) {
    var kitchenOrdersFilter = mapper.asKitchenOrdersFilter(kitchenOrdersFilterDTO);
    Page<KitchenOrder> pageKitchenOrder = restaurantOrdersService.searchKitchenOrders(kitchenOrdersFilter, pageOf(page, limit, sort));
    KitchenOrderPaginatedDTO responseDTO = mapper.asKitchenOrderPaginatedDTO(pageKitchenOrder);
    return ResponseEntity.status(200).body(responseDTO);
  }

  protected Pageable pageOf(Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort) {
    return PageRequest.of(page.orElse(0), limit.orElse(10));
  }
}
