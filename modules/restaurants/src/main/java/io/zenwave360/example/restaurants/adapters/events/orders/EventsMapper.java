package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.client.orders.events.dtos.Customer;
import io.zenwave360.example.restaurants.client.orders.events.dtos.OrderEvent;
import io.zenwave360.example.restaurants.client.orders.events.dtos.OrderItem;
import io.zenwave360.example.restaurants.core.domain.CustomerDetails;
import io.zenwave360.example.restaurants.core.inbound.dtos.KitchenOrderInput;
import io.zenwave360.example.restaurants.core.inbound.dtos.MenuItemInput;
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
    @Mapping(source ="customerDetails", target = "customer")
    @Mapping( target = "customer.name", expression = "java(customer.getFirstName() + \" \" + customer.getLastName())")
    @Mapping(source = "orderItems", target = "items")
    @Mapping(source = "orderTime", target = "date")
    KitchenOrderInput asKitchenOrder(OrderEvent payload);

    CustomerDetails asCustomerDetails(Customer customer);

    MenuItemInput asMenuItemInput(OrderItem orderItem);

    List<MenuItemInput> asMenuItemInputList(List<OrderItem> orderItems);

    default LocalDateTime map(OffsetDateTime value) {
        return value != null ? value.toLocalDateTime() : null;
    }
}
