package io.zenwave360.example.restaurants.core.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import io.zenwave360.example.restaurants.config.*;
import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.implementation.mappers.*;
import io.zenwave360.example.restaurants.core.inbound.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import io.zenwave360.example.restaurants.core.outbound.events.RestaurantOrdersEventsProducerCaptor;
import io.zenwave360.example.restaurants.core.outbound.mongodb.*;
import io.zenwave360.example.restaurants.infrastructure.mongodb.inmemory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/** Acceptance Test for RestaurantOrdersService. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestaurantOrdersServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    RestaurantOrdersServiceImpl restaurantOrdersService = context.restaurantOrdersService();

    KitchenOrderRepositoryInMemory kitchenOrderRepository = context.kitchenOrderRepository();

    RestaurantOrdersEventsProducerCaptor restaurantOrdersEventsProducer = context.getEventsProducerInMemoryContext().restaurantOrdersEventsProducer();

    @BeforeEach
    void setUp() {
        context.reloadTestData();
    }

    @Test
    @Order(0)
    void testCRUDKitchenOrder() {
        /*
         * var input = new KitchenOrder(); // TODO fill input data var kitchenOrder =
         * restaurantOrdersService.createKitchenOrder(input);
         * assertNotNull(kitchenOrder.getId());
         * assertTrue(kitchenOrderRepository.containsEntity(kitchenOrder));
         * 
         * var id = kitchenOrder.getId(); var kitchenOrderUpdate = new KitchenOrder(); //
         * TODO fill update data assertTrue(kitchenOrderRepository.containsKey(id)); var
         * kitchenOrderUpdated = restaurantOrdersService.updateKitchenOrder(id,
         * kitchenOrderUpdate); assertTrue(kitchenOrderUpdated.isPresent());
         * assertTrue(kitchenOrderRepository.containsEntity(kitchenOrderUpdated.get()));
         * 
         * assertTrue(kitchenOrderRepository.containsKey(id));
         * restaurantOrdersService.deleteKitchenOrder(id);
         * assertFalse(kitchenOrderRepository.containsKey(id));
         */
    }

    @Test
    @Order(0)
    void createKitchenOrderTest() {
        var input = new KitchenOrderInput();
         input.setOrderId(UUID.randomUUID().toString());
         input.setRestaurantId("1");
         input.setDate(LocalDateTime.now());
         input.setItems(List.of( //
                 new MenuItem().setId("1").setName("Pan Galactic Gargle Blaster").setPrice(BigDecimal.valueOf(10.0))
         ));
         input.setCustomer(new CustomerDetails() //
                .setName("Rompetechos")
                .setAddress(new CustomerAddress().setStreet("Rua del Percebe, 13"))
         );
        var kitchenOrder = restaurantOrdersService.createKitchenOrder(input);

        assertNotNull(kitchenOrder.getId());
        assertTrue(kitchenOrderRepository.containsEntity(kitchenOrder));
        var capturedMessages = restaurantOrdersEventsProducer
                .getCapturedMessages(restaurantOrdersEventsProducer.onKitchenOrderStatusUpdatedBindingName);
        assertEquals(1, capturedMessages.size());
    }

    @Test
    @Order(1)
    void onOrderStatusUpdatedTest() { // TODO: implement this test
    }

    @Test
    @Order(2)
    void updateKitchenOrderStatusTest() { // TODO: implement this test
    }

    @Test
    @Order(3)
    void searchKitchenOrdersTest() { // TODO: implement this test
    }

}
