package io.zenwave360.example.restaurants.infrastructure.mongodb;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.outbound.mongodb.RestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    public void findAllTest() {
        var results = restaurantRepository.findAll();
        Assertions.assertFalse(results.isEmpty());
    }

    @Test
    public void findByIdTest() {
        var id = "1";
        var restaurant = restaurantRepository.findById(id).orElseThrow();
        Assertions.assertTrue(restaurant.getId() != null);
        Assertions.assertTrue(restaurant.getVersion() != null);
    }

    @Test
    public void saveTest() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(null);
        restaurant.setPhone(null);
        restaurant.setAddress(null);

        var created = restaurantRepository.save(restaurant);
        Assertions.assertTrue(created.getId() != null);
        Assertions.assertTrue(created.getVersion() != null);
    }

    @Test
    public void updateTest() {
        var id = "1";
        var restaurant = restaurantRepository.findById(id).orElseThrow();
        restaurant.setName(null);
        restaurant.setPhone(null);
        restaurant.setAddress(null);

        restaurant = restaurantRepository.save(restaurant);
        Assertions.assertEquals("", restaurant.getName());
        Assertions.assertEquals("", restaurant.getPhone());
        Assertions.assertEquals("", restaurant.getAddress());
    }

    @Test
    public void deleteTest() {
        var id = "1";
        restaurantRepository.deleteById(id);
        var notFound = restaurantRepository.findById(id);
        Assertions.assertFalse(notFound.isPresent());
    }

}
