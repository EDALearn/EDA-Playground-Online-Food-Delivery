package io.zenwave360.example.restaurants.core.implementation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import io.zenwave360.example.restaurants.config.*;
import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.implementation.mappers.*;
import io.zenwave360.example.restaurants.core.inbound.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import io.zenwave360.example.restaurants.core.outbound.mongodb.*;
import io.zenwave360.example.restaurants.infrastructure.mongodb.inmemory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Acceptance Test for RestaurantBackOfficeService. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestaurantBackOfficeServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    RestaurantBackOfficeServiceImpl restaurantBackOfficeService = context.restaurantBackOfficeService();

    RestaurantRepositoryInMemory restaurantRepository = context.restaurantRepository();

    MenuItemRepositoryInMemory menuItemRepository = context.menuItemRepository();

    @BeforeEach
    void setUp() {
        restaurantRepository.save(new Restaurant());
        menuItemRepository.save(new MenuItem());
    }

    @Test
    @Order(0)
    void testCRUDRestaurant() {
        /*
         * var input = new Restaurant(); // TODO fill input data var restaurant =
         * restaurantBackOfficeService.createRestaurant(input);
         * assertNotNull(restaurant.getId());
         * assertTrue(restaurantRepository.containsEntity(restaurant));
         * 
         * var id = restaurant.getId(); var restaurantUpdate = new Restaurant(); // TODO
         * fill update data assertTrue(restaurantRepository.containsKey(id)); var
         * restaurantUpdated = restaurantBackOfficeService.updateRestaurant(id,
         * restaurantUpdate); assertTrue(restaurantUpdated.isPresent());
         * assertTrue(restaurantRepository.containsEntity(restaurantUpdated.get()));
         * 
         * assertTrue(restaurantRepository.containsKey(id));
         * restaurantBackOfficeService.deleteRestaurant(id);
         * assertFalse(restaurantRepository.containsKey(id));
         */
    }

    @Test
    @Order(0)
    void testCRUDMenuItem() {
        /*
         * var input = new MenuItem(); // TODO fill input data var menuItem =
         * restaurantBackOfficeService.createMenuItem(input);
         * assertNotNull(menuItem.getId());
         * assertTrue(menuItemRepository.containsEntity(menuItem));
         * 
         * var id = menuItem.getId(); var menuItemUpdate = new MenuItem(); // TODO fill
         * update data assertTrue(menuItemRepository.containsKey(id)); var menuItemUpdated
         * = restaurantBackOfficeService.updateMenuItem(id, menuItemUpdate);
         * assertTrue(menuItemUpdated.isPresent());
         * assertTrue(menuItemRepository.containsEntity(menuItemUpdated.get()));
         * 
         * assertTrue(menuItemRepository.containsKey(id));
         * restaurantBackOfficeService.deleteMenuItem(id);
         * assertFalse(menuItemRepository.containsKey(id));
         */
    }

    @Test
    @Order(0)
    void createRestaurantTest() {
        var input = new Restaurant();
        // TODO fill input data
        // input.setName("aa");
        // input.setPhone("");
        // input.setAddress(new Address());
        var restaurant = restaurantBackOfficeService.createRestaurant(input);
        assertNotNull(restaurant.getId());
        assertTrue(restaurantRepository.containsEntity(restaurant)); // TODO: implement
                                                                     // this test
    }

    @Test
    @Order(1)
    void getRestaurantTest() {
        var id = "1"; // TODO fill id
        var restaurant = restaurantBackOfficeService.getRestaurant(id);
        assertTrue(restaurant.isPresent()); // TODO: implement this test
    }

    @Test
    @Order(2)
    void listRestaurantsTest() {
        // var results = restaurantBackOfficeService.listRestaurants(PageRequest.of(0,
        // 10));
        // assertNotNull(results);// TODO: implement this test
    }

    @Test
    @Order(3)
    void createMenuItemTest() { // TODO: implement this test
        var input = new MenuItem();
        // TODO fill input data
        // input.setRestaurantId("");
        // input.setName("aa");
        // input.setDescription("");
        // input.setPrice(BigDecimal.valueOf(0));
        var menuItem = restaurantBackOfficeService.createMenuItem(input);
        assertNotNull(menuItem.getId());
        assertTrue(menuItemRepository.containsEntity(menuItem));
    }

    @Test
    @Order(4)
    void updateMenuItemTest() { // TODO: implement this test
        var id = "1"; // TODO fill id
        var input = new MenuItem();
        // TODO fill input data
        // input.setRestaurantId("");
        // input.setName("aa");
        // input.setDescription("");
        // input.setPrice(BigDecimal.valueOf(0));
        assertTrue(menuItemRepository.containsKey(id));
        var menuItem = restaurantBackOfficeService.updateMenuItem(id, input);
        assertTrue(menuItem.isPresent());
        assertTrue(menuItemRepository.containsEntity(menuItem.get()));
    }

    @Test
    @Order(5)
    void listMenuItemsTest() { // TODO: implement this test
        // var results = restaurantBackOfficeService.listMenuItems(PageRequest.of(0, 10));
        // assertNotNull(results);
    }

}
