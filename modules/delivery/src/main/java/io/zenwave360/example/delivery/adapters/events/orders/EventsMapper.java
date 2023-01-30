package io.zenwave360.example.delivery.adapters.events.orders;

import io.zenwave360.example.delivery.client.orders.events.dtos.OrderEvent;
import io.zenwave360.example.delivery.core.domain.OrderItem;
import io.zenwave360.example.delivery.core.inbound.dtos.DeliveryInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.TimeZone;

@Mapper
public interface EventsMapper {

    EventsMapper INSTANCE = Mappers.getMapper(EventsMapper.class);

    default Instant asInstant(OffsetDateTime date) {
        return date != null ? date.toInstant() : null;
    }

    default OffsetDateTime asOffsetDateTime(Instant date) {
        return date != null ? OffsetDateTime.ofInstant(date, TimeZone.getTimeZone("UTC").toZoneId()) : null;
    }

    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "restaurantDetails.restaurantId", target = "restaurantId")
    @Mapping(source ="customerDetails.customerId", target = "customerId")
    @Mapping(source = "orderItems", target = "items")
    @Mapping(source = "orderTime", target = "date")
    DeliveryInput asDeliveryInput(OrderEvent payload);

    OrderItem aOrderItem(io.zenwave360.example.delivery.client.orders.events.dtos.OrderItemInput orderItem);

    List<OrderItem> asOrderItemList(List<io.zenwave360.example.delivery.client.orders.events.dtos.OrderItemInput> orderItems);

    default LocalDateTime map(OffsetDateTime value) {
        return value != null ? value.toLocalDateTime() : null;
    }
}
