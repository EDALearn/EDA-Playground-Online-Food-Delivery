package io.zenwave360.example.restaurants.adapters.web.mappers;

import io.zenwave360.example.restaurants.adapters.web.model.*;
import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.math.*;
import java.time.*;
import java.util.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = BaseMapper.class)
public interface RestaurantOrdersDTOsMapper {

    RestaurantOrdersDTOsMapper INSTANCE = Mappers.getMapper(RestaurantOrdersDTOsMapper.class);

    // request mappings
    KitchenOrdersFilter asKitchenOrdersFilter(KitchenOrdersFilterDTO dto);

    KitchenOrderStatusInput asKitchenOrderStatusInput(KitchenOrderStatusInputDTO dto);

    // response mappings

    List<KitchenOrderDTO> asKitchenOrderDTOList(List<KitchenOrder> entityList);

    KitchenOrderPaginatedDTO asKitchenOrderPaginatedDTO(Page<KitchenOrder> page);

    default Page<KitchenOrderDTO> asKitchenOrderDTOPage(Page<KitchenOrder> page) {
        return page.map(this::asKitchenOrderDTO);
    }

    KitchenOrderDTO asKitchenOrderDTO(KitchenOrder entity);

}
