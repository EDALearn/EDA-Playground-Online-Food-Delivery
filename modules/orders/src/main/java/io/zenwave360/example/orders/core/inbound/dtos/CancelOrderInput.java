package io.zenwave360.example.orders.core.inbound.dtos;

import io.zenwave360.example.orders.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** CancelOrderInput. */
@lombok.Getter
@lombok.Setter
public class CancelOrderInput implements Serializable {

    private String id;

    private String reason;

}
