package io.zenwave360.example.delivery.core.inbound.dtos;

import io.zenwave360.example.delivery.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** OrderStatusUpdated. */
@lombok.Getter
@lombok.Setter
public class OrderStatusUpdated implements Serializable {

    private String orderId;

    private Instant dateTime;

    private String status;

    private String previousStatus;

}
