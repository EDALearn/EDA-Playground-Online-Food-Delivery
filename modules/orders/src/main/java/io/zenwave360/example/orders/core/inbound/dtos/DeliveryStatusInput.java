package io.zenwave360.example.orders.core.inbound.dtos;

import io.zenwave360.example.orders.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** DeliveryStatusInput. */
@lombok.Getter
@lombok.Setter
public class DeliveryStatusInput implements Serializable {

    private String deliveryOrderId;

    private DeliveryStatus deliveryStatus;

}
