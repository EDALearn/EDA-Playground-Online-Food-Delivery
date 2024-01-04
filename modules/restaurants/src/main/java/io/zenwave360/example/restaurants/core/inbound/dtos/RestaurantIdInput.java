package io.zenwave360.example.restaurants.core.inbound.dtos;

import io.zenwave360.example.restaurants.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** RestaurantIdInput. */
@lombok.Getter
@lombok.Setter
public class RestaurantIdInput implements Serializable {

    @NotNull
    private String restaurantId;

}
