package io.zenwave360.example.restaurants.adapters.web;

import io.zenwave360.example.restaurants.adapters.web.model.*;
import io.zenwave360.example.restaurants.config.ServicesInMemoryConfig;
import java.math.*;
import java.time.*;
import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Test controller for RestaurantBackOfficeApiController. */
public class RestaurantBackOfficeApiControllerTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    RestaurantBackOfficeApiController controller = new RestaurantBackOfficeApiController()
        .setRestaurantBackOfficeService(context.restaurantBackOfficeService());

    @BeforeEach
    void setUp() {
        context.reloadTestData();
    }

    @Test
    public void createRestaurantTest() {
        RestaurantDTO reqBody = null;
        var response = controller.createRestaurant(reqBody);
        Assertions.assertEquals(201, response.getStatusCode().value());
    }

    @Test
    public void listRestaurantsTest() {
        Optional<Integer> page = null;
        Optional<Integer> limit = null;
        Optional<List<String>> sort = null;
        var response = controller.listRestaurants(page, limit, sort);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void getRestaurantTest() {
        String restaurantId = null;
        var response = controller.getRestaurant(restaurantId);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void createMenuItemTest() {
        String restaurantId = null;
        MenuItemDTO reqBody = null;
        var response = controller.createMenuItem(restaurantId, reqBody);
        Assertions.assertEquals(201, response.getStatusCode().value());
    }

    @Test
    public void listMenuItemsTest() {
        String restaurantId = null;
        var response = controller.listMenuItems(restaurantId);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void updateMenuItemTest() {
        String restaurantId = null;
        String name = null;
        MenuItemDTO reqBody = null;
        var response = controller.updateMenuItem(restaurantId, name, reqBody);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

}
