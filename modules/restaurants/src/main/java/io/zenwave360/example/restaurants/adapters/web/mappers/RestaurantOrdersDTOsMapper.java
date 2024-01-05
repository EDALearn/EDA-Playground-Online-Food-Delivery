package io.zenwave360.example.restaurants.adapters.web.mappers;

import io.zenwave360.example.restaurants.adapters.web.model.*;
import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = BaseMapper.class)
public interface RestaurantOrdersDTOsMapper {

  RestaurantOrdersDTOsMapper INSTANCE = Mappers.getMapper(RestaurantOrdersDTOsMapper.class);

  // request mappings


  KitchenOrderStatusInput asKitchenOrderStatusInput(KitchenOrderStatusInputDTO dto);

  // response mappings
  KitchenOrderDTO asKitchenOrderDTO(KitchenOrder entity);

  KitchenOrderPaginatedDTO asKitchenOrderPaginatedDTO(Page<KitchenOrder> entity);

  // response paginated mappings
  List<KitchenOrderDTO> asKitchenOrderDTOList(List<KitchenOrder> entityList);

  default Page<KitchenOrderDTO> asKitchenOrderDTOPage(Page<KitchenOrder> page) {
    return page.map(this::asKitchenOrderDTO);
  }

  KitchenOrdersFilter asKitchenOrdersFilter(KitchenOrdersFilterDTO kitchenOrdersFilterDTO);

  KitchenOrderStatus asKitchenOrderStatus(KitchenOrderStatusDTO dto);

  KitchenOrderStatusDTO asKitchenOrderStatusDTO(KitchenOrderStatus enumValue);
}
