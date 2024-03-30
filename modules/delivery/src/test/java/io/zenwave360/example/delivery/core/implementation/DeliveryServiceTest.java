package io.zenwave360.example.delivery.core.implementation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import io.zenwave360.example.delivery.config.*;
import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.implementation.mappers.*;
import io.zenwave360.example.delivery.core.inbound.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import io.zenwave360.example.delivery.core.outbound.mongodb.*;
import io.zenwave360.example.delivery.infrastructure.mongodb.inmemory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Acceptance Test for DeliveryService. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeliveryServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    DeliveryServiceImpl deliveryService = context.deliveryService();

    DeliveryRepositoryInMemory deliveryRepository = context.deliveryRepository();

    @BeforeEach
    void setUp() {
        context.reloadTestData();
    }

    @Test
    @Order(0)
    void testCRUDDelivery() {
        /*
         * var input = new Delivery(); // TODO fill input data var delivery =
         * deliveryService.createDelivery(input); assertNotNull(delivery.getId());
         * assertTrue(deliveryRepository.containsEntity(delivery));
         * 
         * var id = delivery.getId(); var deliveryUpdate = new Delivery(); // TODO fill
         * update data assertTrue(deliveryRepository.containsKey(id)); var deliveryUpdated
         * = deliveryService.updateDelivery(id, deliveryUpdate);
         * assertTrue(deliveryUpdated.isPresent());
         * assertTrue(deliveryRepository.containsEntity(deliveryUpdated.get()));
         * 
         * assertTrue(deliveryRepository.containsKey(id));
         * deliveryService.deleteDelivery(id);
         * assertFalse(deliveryRepository.containsKey(id));
         */
    }

    @Test
    @Order(0)
    void createDeliveryTest() {
        var input = new DeliveryInput();
        // TODO fill input data
        // input.setOrderId("");
        // input.setCustomer(new Customer());
        // input.setRestaurant(new Restaurant());
        // input.setOrderItems(new OrderItem());
        // input.setStatus(DeliveryOrderStatus.values()[0]);
        var delivery = deliveryService.createDelivery(input);
        assertNotNull(delivery.getId());
        assertTrue(deliveryRepository.containsEntity(delivery));
    }

    @Test
    @Order(1)
    void onOrderStatusUpdatedTest() { // TODO: implement this test
    }

    @Test
    @Order(2)
    void updateDeliveryStatusTest() { // TODO: implement this test
    }

    @Test
    @Order(3)
    void listDeliveriesTest() {
        // var results = deliveryService.listDeliveries(PageRequest.of(0, 10));
        // assertNotNull(results);
    }

}
