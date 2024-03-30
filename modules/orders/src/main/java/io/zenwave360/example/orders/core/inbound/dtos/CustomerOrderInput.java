package io.zenwave360.example.orders.core.inbound.dtos;

import io.zenwave360.example.orders.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** CustomerOrderInput. */
@lombok.Getter
@lombok.Setter
public class CustomerOrderInput implements Serializable {

    private Instant orderTime;

    private OrderStatus status;

    @NotNull
    private String customerId;

    @NotNull
    private String restaurantId;

    @NotNull
    private String addressIdentifier;

    private List<OrderItem> orderItems = new ArrayList<>();

    public CustomerOrderInput addOrderItems(OrderItem orderItems) {
        this.orderItems.add(orderItems);
        return this;
    }

}
