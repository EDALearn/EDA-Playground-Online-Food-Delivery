package io.zenwave360.example.restaurants.core.inbound;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [Restaurant, MenuItem]. */
public interface RestaurantBackOfficeService {

    /**
     * Creates a restaurant.
     * @param restaurant the entity to save.
     * @return the persisted entity.
     */
    /** */
    public Restaurant createRestaurant(Restaurant input);

    /**
     * Get the "id" restaurant.
     * @param id the id of the entity.
     * @return the entity.
     */
    /** */
    public Optional<Restaurant> getRestaurant(String id);

    /**
     * Get all the Restaurants.
     * @param criteria the criteria with pagination information.
     * @return the list of entities.
     */
    /** */
    public Page<Restaurant> listRestaurants(Pageable pageable);

    /** */
    /**
     * Creates a menuItem.
     * @param menuItem the entity to save.
     * @return the persisted entity.
     */
    public MenuItem createMenuItem(MenuItem input);

    /** */
    /**
     * Updates a menuItem.
     * @param menuItem the entity to update.
     * @return the persisted entity.
     */
    public Optional<MenuItem> updateMenuItem(String id, MenuItem input);

    /** */
    /**
     * Get all the MenuItems.
     * @param criteria the criteria with pagination information.
     * @return the list of entities.
     */
    public List<MenuItem> listMenuItems(String restaurantId);

}
