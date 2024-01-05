package io.zenwave360.example.orders.core.inbound.dtos;

import io.zenwave360.example.orders.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** KitchenStatusInput. */
@lombok.Getter
@lombok.Setter
public class KitchenStatusInput implements Serializable {

    private String kitchenOrderId;

    private KitchenStatus kitchenStatus;

}
