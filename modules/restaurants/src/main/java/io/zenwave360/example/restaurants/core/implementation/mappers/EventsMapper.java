package io.zenwave360.example.restaurants.core.implementation.mappers;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface EventsMapper {

    EventsMapper INSTANCE = Mappers.getMapper(EventsMapper.class);

    io.zenwave360.example.restaurants.core.domain.events.KitchenOrderStatusUpdated asKitchenOrderStatusUpdated(
            OrderStatusUpdated input);

    io.zenwave360.example.restaurants.core.domain.events.RestaurantEvent asRestaurantEvent(Restaurant restaurant);

    io.zenwave360.example.restaurants.core.domain.events.KitchenOrderStatusUpdated asKitchenOrderStatusUpdated(
            KitchenOrder kitchenOrder);

    io.zenwave360.example.restaurants.core.domain.events.KitchenOrderStatus asKitchenOrderStatus(
            KitchenOrderStatus kitchenOrderStatus);

}
