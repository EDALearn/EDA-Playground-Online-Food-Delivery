package io.zenwave360.example.customers.core.domain;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
@lombok.Getter
@lombok.Setter
public class Address implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 1L;

    /** Description identifier for this Address */
    @Field
    @NotNull
    private String identifier;

    @Field
    @NotNull
    private String street;

    @Field
    private String city;

    @Field
    private String state;

    @Field
    private String zip;

    /** address type is an enum */
    @Field
    @NotNull
    private AddressType type;

}
