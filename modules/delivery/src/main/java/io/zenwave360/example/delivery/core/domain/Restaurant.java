package io.zenwave360.example.delivery.core.domain;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
@lombok.Getter
@lombok.Setter
public class Restaurant implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    @Field
    private String restaurantId;

    @Field
    private String name;

    @Field
    private String phone;

    @Field
    private Address address;

}
