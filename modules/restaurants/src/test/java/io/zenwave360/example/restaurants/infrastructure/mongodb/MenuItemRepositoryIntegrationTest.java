package io.zenwave360.example.restaurants.infrastructure.mongodb;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.outbound.mongodb.MenuItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuItemRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

    @Autowired
    MenuItemRepository menuItemRepository;

    @Test
    public void findAllTest() {
        var results = menuItemRepository.findAll();
        Assertions.assertFalse(results.isEmpty());
    }

    @Test
    public void findByIdTest() {
        var id = "1";
        var menuItem = menuItemRepository.findById(id).orElseThrow();
        Assertions.assertTrue(menuItem.getId() != null);
        Assertions.assertTrue(menuItem.getVersion() != null);
    }

    @Test
    public void saveTest() {
        MenuItem menuItem = new MenuItem();
        menuItem.setRestaurantId(null);
        menuItem.setName(null);
        menuItem.setDescription(null);
        menuItem.setPrice(null);

        var created = menuItemRepository.save(menuItem);
        Assertions.assertTrue(created.getId() != null);
        Assertions.assertTrue(created.getVersion() != null);
    }

    @Test
    public void updateTest() {
        var id = "1";
        var menuItem = menuItemRepository.findById(id).orElseThrow();
        menuItem.setRestaurantId(null);
        menuItem.setName(null);
        menuItem.setDescription(null);
        menuItem.setPrice(null);

        menuItem = menuItemRepository.save(menuItem);
        Assertions.assertEquals("", menuItem.getRestaurantId());
        Assertions.assertEquals("", menuItem.getName());
        Assertions.assertEquals("", menuItem.getDescription());
        Assertions.assertEquals("", menuItem.getPrice());
    }

    @Test
    public void deleteTest() {
        var id = "1";
        menuItemRepository.deleteById(id);
        var notFound = menuItemRepository.findById(id);
        Assertions.assertFalse(notFound.isPresent());
    }

}
