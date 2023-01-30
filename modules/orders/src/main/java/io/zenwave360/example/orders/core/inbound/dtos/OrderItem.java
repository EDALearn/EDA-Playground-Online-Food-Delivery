package io.zenwave360.example.orders.core.inbound.dtos;

import io.zenwave360.example.orders.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** OrderItem. */
@lombok.Getter
@lombok.Setter
public class OrderItem implements Serializable {

    @NotNull
    private String menuItemId;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer quantity;

}
