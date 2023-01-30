package io.zenwave360.example.restaurants.infrastructure.mongodb;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.outbound.mongodb.KitchenOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class KitchenOrderRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

    @Autowired
    KitchenOrderRepository kitchenOrderRepository;

    @Test
    public void findAllTest() {
        var results = kitchenOrderRepository.findAll();
        Assertions.assertFalse(results.isEmpty());
    }

    @Test
    public void findByIdTest() {
        var id = "1";
        var kitchenOrder = kitchenOrderRepository.findById(id).orElseThrow();
        Assertions.assertTrue(kitchenOrder.getId() != null);
        Assertions.assertTrue(kitchenOrder.getVersion() != null);
    }

    @Test
    public void saveTest() {
        KitchenOrder kitchenOrder = new KitchenOrder();
        kitchenOrder.setOrderId(null);
        kitchenOrder.setRestaurantId(null);
        kitchenOrder.setDate(null);
        kitchenOrder.setItems(null);
        kitchenOrder.setStatus(null);
        kitchenOrder.setCustomer(null);

        var created = kitchenOrderRepository.save(kitchenOrder);
        Assertions.assertTrue(created.getId() != null);
        Assertions.assertTrue(created.getVersion() != null);
    }

    @Test
    public void updateTest() {
        var id = "1";
        var kitchenOrder = kitchenOrderRepository.findById(id).orElseThrow();
        kitchenOrder.setOrderId(null);
        kitchenOrder.setRestaurantId(null);
        kitchenOrder.setDate(null);
        kitchenOrder.setItems(null);
        kitchenOrder.setStatus(null);
        kitchenOrder.setCustomer(null);

        kitchenOrder = kitchenOrderRepository.save(kitchenOrder);
        Assertions.assertEquals("", kitchenOrder.getOrderId());
        Assertions.assertEquals("", kitchenOrder.getRestaurantId());
        Assertions.assertEquals("", kitchenOrder.getDate());
        Assertions.assertEquals("", kitchenOrder.getItems());
        Assertions.assertEquals("", kitchenOrder.getStatus());
        Assertions.assertEquals("", kitchenOrder.getCustomer());
    }

    @Test
    public void deleteTest() {
        var id = "1";
        kitchenOrderRepository.deleteById(id);
        var notFound = kitchenOrderRepository.findById(id);
        Assertions.assertFalse(notFound.isPresent());
    }

}
