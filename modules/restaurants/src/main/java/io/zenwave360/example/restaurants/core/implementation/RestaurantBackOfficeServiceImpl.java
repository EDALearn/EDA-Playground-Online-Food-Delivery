package io.zenwave360.example.restaurants.core.implementation;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.implementation.mappers.*;
import io.zenwave360.example.restaurants.core.inbound.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
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
public class RestaurantBackOfficeServiceImpl implements RestaurantBackOfficeService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final RestaurantMapper restaurantMapper = RestaurantMapper.INSTANCE;

    private final RestaurantRepository restaurantRepository;

    private final MenuItemMapper menuItemMapper = MenuItemMapper.INSTANCE;

    private final MenuItemRepository menuItemRepository;

    /** Constructor. */
    public RestaurantBackOfficeServiceImpl(RestaurantRepository restaurantRepository,
            MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;

        this.menuItemRepository = menuItemRepository;
    }

    @Transactional
    public Restaurant createRestaurant(Restaurant input) {
        log.debug("Request to save Restaurant: {}", input);
        var restaurant = restaurantMapper.update(new Restaurant(), input);
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
        var menuItem = menuItemMapper.update(new MenuItem(), input);
        menuItem = menuItemRepository.save(menuItem);
        return menuItem;
    }

    @Transactional
    public Optional<MenuItem> updateMenuItem(String id, MenuItem input) {
        log.debug("Request to update MenuItem : {}", input);
        var menuItem = menuItemRepository.findById(id).map(existingMenuItem -> {
            return menuItemMapper.update(existingMenuItem, input);
        }).map(menuItemRepository::save);
        return menuItem;
    }

    public List<MenuItem> listMenuItems(String restaurantId) {
        log.debug("Request list of MenuItems for restaurantId: {}", restaurantId);
        var results = menuItemRepository.findAllByRestaurantId(restaurantId);
        return results;
    }

}
