package io.zenwave360.example.orders.core.implementation.mappers;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface EventsMapper {

    EventsMapper INSTANCE = Mappers.getMapper(EventsMapper.class);

    io.zenwave360.example.orders.core.outbound.events.dtos.OrderStatus asOrderStatus(OrderStatus orderStatus);

    io.zenwave360.example.orders.core.outbound.events.dtos.Restaurant asRestaurant(Restaurant restaurant);

    io.zenwave360.example.orders.core.outbound.events.dtos.OrderItemInput asOrderItemInput(
            OrderItemInput orderItemInput);

    io.zenwave360.example.orders.core.outbound.events.dtos.Customer asCustomer(Customer customer);

    io.zenwave360.example.orders.core.outbound.events.dtos.OrderStatusUpdated asOrderStatusUpdated(
            CustomerOrder customerOrder);

    io.zenwave360.example.orders.core.outbound.events.dtos.OrderEvent asOrderEvent(CustomerOrder customerOrder);

}
