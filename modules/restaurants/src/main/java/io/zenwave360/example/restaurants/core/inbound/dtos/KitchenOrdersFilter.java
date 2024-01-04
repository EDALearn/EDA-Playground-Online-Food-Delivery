package io.zenwave360.example.restaurants.core.inbound.dtos;

import io.zenwave360.example.restaurants.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** KitchenOrdersFilter. */
@lombok.Getter
@lombok.Setter
public class KitchenOrdersFilter implements Serializable {

    private String restaurantId;

    private KitchenOrderStatus status;

}
