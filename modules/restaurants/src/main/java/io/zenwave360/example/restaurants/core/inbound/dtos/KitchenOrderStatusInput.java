package io.zenwave360.example.restaurants.core.inbound.dtos;

import io.zenwave360.example.restaurants.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** KitchenOrderStatusInput. */
@lombok.Getter
@lombok.Setter
public class KitchenOrderStatusInput implements Serializable {

    @NotNull
    private KitchenOrderStatus status;

    @NotNull
    private String operatorName;

}
