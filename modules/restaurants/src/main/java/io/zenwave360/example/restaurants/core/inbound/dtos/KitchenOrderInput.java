package io.zenwave360.example.restaurants.core.inbound.dtos;

import io.zenwave360.example.restaurants.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** KitchenOrderInput. */
@lombok.Getter
@lombok.Setter
public class KitchenOrderInput implements Serializable {

    @NotNull
    private String orderId;

    @NotNull
    private String restaurantId;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private List<MenuItem> items = new ArrayList<>();

    @NotNull
    private CustomerDetails customer;

    public KitchenOrderInput addItems(MenuItem items) {
        this.items.add(items);
        return this;
    }

}
