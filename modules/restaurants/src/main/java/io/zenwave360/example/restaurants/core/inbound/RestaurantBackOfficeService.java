package io.zenwave360.example.restaurants.core.inbound;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.math.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [Restaurant, MenuItem]. */
public interface RestaurantBackOfficeService {

    /** With Events: [RestaurantEvent]. */
    public Restaurant createRestaurant(Restaurant input);

    /** */
    public Optional<Restaurant> getRestaurant(String id);

    /** */
    public Page<Restaurant> listRestaurants(Pageable pageable);

    /** */
    public MenuItem createMenuItem(MenuItem input);

    /** */
    public Optional<MenuItem> updateMenuItem(String id, MenuItem input);

    /** */
    public List<MenuItem> listMenuItems(String restaurantId);

}
