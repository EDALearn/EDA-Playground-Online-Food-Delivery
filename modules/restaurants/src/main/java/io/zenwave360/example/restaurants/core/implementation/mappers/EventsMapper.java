package io.zenwave360.example.restaurants.core.implementation.mappers;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface EventsMapper {

    EventsMapper INSTANCE = Mappers.getMapper(EventsMapper.class);

    io.zenwave360.example.restaurants.core.outbound.events.dtos.KitchenOrderStatusUpdated asKitchenOrderStatusUpdated(
            OrderStatusUpdated input);

    io.zenwave360.example.restaurants.core.outbound.events.dtos.RestaurantEvent asRestaurantEvent(Restaurant input);

    io.zenwave360.example.restaurants.core.outbound.events.dtos.KitchenOrderStatusUpdated asKitchenOrderStatusUpdated(
            KitchenOrder kitchenOrder);

    io.zenwave360.example.restaurants.core.outbound.events.dtos.KitchenOrderStatus asKitchenOrderStatus(
            KitchenOrderStatus kitchenOrderStatus);

}
