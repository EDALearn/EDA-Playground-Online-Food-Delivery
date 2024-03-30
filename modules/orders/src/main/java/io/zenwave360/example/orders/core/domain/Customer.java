package io.zenwave360.example.orders.core.domain;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
@lombok.Getter
@lombok.Setter
public class Customer implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    @Field
    @NotNull
    private String customerId;

    @Field
    @NotNull
    private String firstName;

    @Field
    @NotNull
    private String lastName;

    @Field
    @NotNull
    private String email;

    @Field
    @NotNull
    private String phone;

    @Field
    private Address address;

}
