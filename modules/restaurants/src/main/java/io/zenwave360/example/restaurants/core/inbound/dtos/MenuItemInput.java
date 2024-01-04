package io.zenwave360.example.restaurants.core.inbound.dtos;

import io.zenwave360.example.restaurants.core.domain.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;

/** MenuItemInput. */
@lombok.Getter
@lombok.Setter
public class MenuItemInput implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private MenuItem menuItem;

}
