package io.zenwave360.example.restaurants.core.domain;

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

    @Field
    @NotNull
    private String street;

    @Field
    @NotNull
    private String city;

    @Field
    @NotNull
    private String state;

    @Field
    @NotNull
    private String zip;

}
