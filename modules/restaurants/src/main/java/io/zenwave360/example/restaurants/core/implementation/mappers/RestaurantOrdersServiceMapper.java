package io.zenwave360.example.restaurants.core.implementation.mappers;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface RestaurantOrdersServiceMapper {

    RestaurantOrdersServiceMapper INSTANCE = Mappers.getMapper(RestaurantOrdersServiceMapper.class);

    // KitchenOrder asKitchenOrder(OrderStatusUpdated input);

    @Mapping(target = "id", ignore = true)
    KitchenOrder update(@MappingTarget KitchenOrder entity, OrderStatusUpdated input);
    // KitchenOrder asKitchenOrder(KitchenOrderStatusInput input);

    @Mapping(target = "id", ignore = true)
    KitchenOrder update(@MappingTarget KitchenOrder entity, KitchenOrderStatusInput input);
    // KitchenOrder asKitchenOrder(KitchenOrderInput input);

    @Mapping(target = "id", ignore = true)
    KitchenOrder update(@MappingTarget KitchenOrder entity, KitchenOrderInput input);
    // KitchenOrder asKitchenOrder(KitchenOrdersFilter input);

    @Mapping(target = "id", ignore = true)
    KitchenOrder update(@MappingTarget KitchenOrder entity, KitchenOrdersFilter input);

}
