package io.zenwave360.example.delivery.core.implementation;

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

    InMemoryTestsManualContext context = InMemoryTestsManualContext.INSTANCE;

    DeliveryServiceImpl deliveryService = context.deliveryService();

    DeliveryRepositoryInMemory deliveryRepository = context.deliveryRepository();

    @BeforeEach
    void setUp() {
        deliveryRepository.save(new Delivery());
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
    void createKitchenOrderTest() { // not legacy
    }

    @Test
    @Order(1)
    void updateDeliveryStatusTest() { // not legacy
    }

}
