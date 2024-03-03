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

/** Test controller for RestaurantOrdersApiController. */
public class RestaurantOrdersApiControllerTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    RestaurantOrdersApiController controller = new RestaurantOrdersApiController()
        .setRestaurantOrdersService(context.restaurantOrdersService());

    @BeforeEach
    void setUp() {
        context.reloadTestData();
    }

    @Test
    public void updateKitchenOrderStatusTest() {
        String orderId = null;
        KitchenOrderStatusInputDTO reqBody = null;
        var response = controller.updateKitchenOrderStatus(orderId, reqBody);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void searchKitchenOrdersTest() {
        Optional<Integer> page = null;
        Optional<Integer> limit = null;
        Optional<List<String>> sort = null;
        KitchenOrdersFilterDTO reqBody = null;
        var response = controller.searchKitchenOrders(page, limit, sort, reqBody);
        Assertions.assertEquals(201, response.getStatusCode().value());
    }

}
