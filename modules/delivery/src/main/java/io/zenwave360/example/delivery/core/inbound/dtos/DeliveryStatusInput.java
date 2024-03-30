package io.zenwave360.example.delivery.core.inbound.dtos;

import io.zenwave360.example.delivery.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** DeliveryStatusInput. */
@lombok.Getter
@lombok.Setter
public class DeliveryStatusInput implements Serializable {

    @NotNull
    private DeliveryOrderStatus status;

    @NotNull
    private String operatorName;

}
