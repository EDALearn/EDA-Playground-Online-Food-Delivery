package io.zenwave360.example.delivery.core.inbound.dtos;

import io.zenwave360.example.delivery.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** DeliveryInput. */
@lombok.Getter
@lombok.Setter
public class DeliveryInput implements Serializable {

    @NotNull
    private String orderId;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private String restaurantId;

    @NotNull
    private String customerId;

    @NotNull
    private List<OrderItem> items = new ArrayList<>();

    public DeliveryInput addItems(OrderItem items) {
        this.items.add(items);
        return this;
    }

}
