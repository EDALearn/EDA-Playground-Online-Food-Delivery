package io.zenwave360.example.delivery.core.domain.events;

import io.zenwave360.example.delivery.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** */
@lombok.Getter
@lombok.Setter
public class DeliveryStatusUpdated implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    private String customerOrderId;

    @NotNull
    private String deliveryId;

    @NotNull
    private DeliveryOrderStatus status;

    private String message;

}
