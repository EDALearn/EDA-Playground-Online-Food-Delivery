package io.zenwave360.example.orders.core.implementation.mappers;

import io.zenwave360.example.orders.core.domain.CustomerOrder;
import io.zenwave360.example.orders.core.domain.DeliveryStatus;
import io.zenwave360.example.orders.core.domain.KitchenStatus;
import io.zenwave360.example.orders.core.domain.OrderStatus;
import io.zenwave360.example.orders.core.domain.events.OrderEvent;
import io.zenwave360.example.orders.core.domain.events.OrderStatusUpdated;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.TimeZone;

@Mapper
public interface OrderEventMapper {

    OrderEventMapper INSTANCE = Mappers.getMapper(OrderEventMapper.class);

    OrderEvent asOrderEvent(CustomerOrder customerOrder);

    default OrderStatusUpdated asOrderStatusUpdated(CustomerOrder customerOrder, OrderStatus previousStatus) {
        return new OrderStatusUpdated() //
            .withId(customerOrder.getId())
            .withDateTime(OffsetDateTime.now())
            .withStatus(asOrderStatus(customerOrder.getStatus()))
            .withPreviousStatus(asOrderStatus(previousStatus));
    }

    default OrderStatusUpdated orderStatusUpdated(String orderId, OrderStatus status, OrderStatus previousStatus) {
        return new OrderStatusUpdated() //
            .withId(orderId)
            .withDateTime(OffsetDateTime.now())
            .withStatus(asOrderStatus(status))
            .withPreviousStatus(asOrderStatus(previousStatus));
    };

    @ValueMapping(source = "REJECTED", target = "CANCELLED")
    @ValueMapping(source = "ACCEPTED", target = "KITCHEN_ACCEPTED")
    @ValueMapping(source = "IN_PROGRESS", target = "KITCHEN_IN_PROGRESS")
    @ValueMapping(source = "READY", target = "KITCHEN_READY")
    @ValueMapping(source = "DELIVERED", target = "KITCHEN_DELIVERED")
    @ValueMapping(source = "CANCELLED", target = "CANCELLED")
    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = MappingConstants.NULL)
    OrderStatus asOrderStatus(KitchenStatus status);

    default OrderStatus asOrderStatus(KitchenStatus kitchenStatus, OrderStatus originalStatus) {
        return ObjectUtils.firstNonNull(asOrderStatus(kitchenStatus), originalStatus);
    }

    @ValueMapping(source = "REJECTED", target = "CANCELLED")
    @ValueMapping(source = "ACCEPTED", target = "DELIVERY_ACCEPTED")
    @ValueMapping(source = "IN_PROGRESS", target = "ON_DELIVERY")
    @ValueMapping(source = "DELIVERED", target = "DELIVERY_ACCEPTED")
    @ValueMapping(source = "CANCELLED", target = "CANCELLED")
    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = MappingConstants.NULL)
    OrderStatus asOrderStatus(DeliveryStatus deliveryStatus);

    default OrderStatus asOrderStatus(DeliveryStatus deliveryStatus, OrderStatus originalStatus) {
        return ObjectUtils.firstNonNull(asOrderStatus(deliveryStatus), originalStatus);
    }

    io.zenwave360.example.orders.core.domain.events.OrderStatus asOrderStatus(OrderStatus status);

    default OffsetDateTime asOffsetDateTime(Instant date) {
        return date != null ? OffsetDateTime.ofInstant(date, TimeZone.getTimeZone("UTC").toZoneId()) : null;
    }
}
