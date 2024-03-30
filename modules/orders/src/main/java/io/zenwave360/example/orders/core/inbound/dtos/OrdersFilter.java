package io.zenwave360.example.orders.core.inbound.dtos;

import io.zenwave360.example.orders.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** OrdersFilter. */
@lombok.Getter
@lombok.Setter
public class OrdersFilter implements Serializable {

    private OrderStatus status;

    private String customerName;

    private String restaurantName;

}
