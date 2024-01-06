package io.zenwave360.example.delivery.infrastructure.mongodb;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.outbound.mongodb.DeliveryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliveryRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Test
    public void findAllTest() {
        var results = deliveryRepository.findAll();
        Assertions.assertFalse(results.isEmpty());
    }

    @Test
    public void findByIdTest() {
        var id = "1";
        var delivery = deliveryRepository.findById(id).orElseThrow();
        Assertions.assertTrue(delivery.getId() != null);
        Assertions.assertTrue(delivery.getVersion() != null);
    }

    @Test
    public void saveTest() {
        Delivery delivery = new Delivery();
        delivery.setOrderId(null);
        delivery.setCustomer(null);
        delivery.setRestaurant(null);
        delivery.setOrderItems(null);
        delivery.setStatus(null);

        var created = deliveryRepository.save(delivery);
        Assertions.assertTrue(created.getId() != null);
        Assertions.assertTrue(created.getVersion() != null);
    }

    @Test
    public void updateTest() {
        var id = "1";
        var delivery = deliveryRepository.findById(id).orElseThrow();
        delivery.setOrderId(null);
        delivery.setCustomer(null);
        delivery.setRestaurant(null);
        delivery.setOrderItems(null);
        delivery.setStatus(null);

        delivery = deliveryRepository.save(delivery);
        Assertions.assertEquals("", delivery.getOrderId());
        Assertions.assertEquals("", delivery.getCustomer());
        Assertions.assertEquals("", delivery.getRestaurant());
        Assertions.assertEquals("", delivery.getOrderItems());
        Assertions.assertEquals("", delivery.getStatus());
    }

    @Test
    public void deleteTest() {
        var id = "1";
        deliveryRepository.deleteById(id);
        var notFound = deliveryRepository.findById(id);
        Assertions.assertFalse(notFound.isPresent());
    }

}
