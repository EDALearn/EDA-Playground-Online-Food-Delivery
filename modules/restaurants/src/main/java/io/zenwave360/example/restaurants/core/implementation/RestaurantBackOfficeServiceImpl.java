package io.zenwave360.example.restaurants.core.implementation;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.implementation.mappers.*;
import io.zenwave360.example.restaurants.core.inbound.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import io.zenwave360.example.restaurants.core.outbound.events.*;
import io.zenwave360.example.restaurants.core.outbound.mongodb.*;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [Restaurant, MenuItem]. */
@Service
@Transactional(readOnly = true)
@lombok.AllArgsConstructor
public class RestaurantBackOfficeServiceImpl implements RestaurantBackOfficeService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final RestaurantBackOfficeServiceMapper restaurantBackOfficeServiceMapper = RestaurantBackOfficeServiceMapper.INSTANCE;

    private final RestaurantRepository restaurantRepository;

    private final MenuItemRepository menuItemRepository;

    @Transactional
    public Restaurant createRestaurant(Restaurant input) {
        log.debug("Request to save Restaurant: {}", input);
        var restaurant = restaurantBackOfficeServiceMapper.update(new Restaurant(), input);
        restaurant = restaurantRepository.save(restaurant);
        return restaurant;
    }

    public Optional<Restaurant> getRestaurant(String id) {
        log.debug("Request to get Restaurant : {}", id);
        var restaurant = restaurantRepository.findById(id);
        return restaurant;
    }

    public Page<Restaurant> listRestaurants(Pageable pageable) {
        log.debug("Request list of Restaurants: {}", pageable);
        var page = restaurantRepository.findAll(pageable);
        return page;
    }

    @Transactional
    public MenuItem createMenuItem(MenuItem input) {
        log.debug("Request to save MenuItem: {}", input);
        var menuItem = restaurantBackOfficeServiceMapper.update(new MenuItem(), input);
        menuItem = menuItemRepository.save(menuItem);
        return menuItem;
    }

    @Transactional
    public Optional<MenuItem> updateMenuItem(String id, MenuItem input) {
        log.debug("Request to update MenuItem : {}", input);
        var menuItem = menuItemRepository.findById(id).map(existingMenuItem -> {
            return restaurantBackOfficeServiceMapper.update(existingMenuItem, input);
        }).map(menuItemRepository::save);
        return menuItem;
    }

    public List<MenuItem> listMenuItems(String restaurantId) {
        log.debug("Request list of MenuItems");
        var menuItems = menuItemRepository.findAll();
        return menuItems;
    }

}
