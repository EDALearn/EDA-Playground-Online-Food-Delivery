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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/** Acceptance Test for RestaurantOrdersService. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestaurantOrdersServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    InMemoryTestsManualContext context = InMemoryTestsManualContext.INSTANCE;

    RestaurantOrdersServiceImpl restaurantOrdersService = context.restaurantOrdersService();

    KitchenOrderRepositoryInMemory kitchenOrderRepository = context.kitchenOrderRepository();

    @BeforeEach
    void setUp() {
        kitchenOrderRepository.save(new KitchenOrder());
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
        // TODO fill input data
        var kitchenOrder = restaurantOrdersService.createKitchenOrder(input);
        assertNotNull(kitchenOrder.getId());
        assertTrue(kitchenOrderRepository.containsEntity(kitchenOrder));
    }

    @Test
    @Order(1)
    void updateKitchenOrderStatusTest() { // not legacy
    }

    @Test
    @Order(2)
    void searchKitchenOrdersTest() {
        var kitchenOrdersFilter = new KitchenOrdersFilter();
        // TODO fill criteria
        var results = restaurantOrdersService.searchKitchenOrders(kitchenOrdersFilter, PageRequest.of(0, 10));
        assertNotNull(results);
    }

}
