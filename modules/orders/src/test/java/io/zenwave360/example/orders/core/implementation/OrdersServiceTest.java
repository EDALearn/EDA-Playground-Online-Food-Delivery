package io.zenwave360.example.orders.core.implementation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import io.zenwave360.example.orders.config.*;
import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.implementation.mappers.*;
import io.zenwave360.example.orders.core.inbound.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import io.zenwave360.example.orders.core.outbound.mongodb.*;
import io.zenwave360.example.orders.infrastructure.mongodb.inmemory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Acceptance Test for OrdersService. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrdersServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    OrdersServiceImpl ordersService = context.ordersService();

    CustomerOrderRepositoryInMemory customerOrderRepository = context.customerOrderRepository();

    @BeforeEach
    void setUp() {
        context.reloadTestData();
    }

    @Test
    @Order(0)
    void testCRUDCustomerOrder() {
        /*
         * var input = new CustomerOrder(); // TODO fill input data var customerOrder =
         * ordersService.createCustomerOrder(input); assertNotNull(customerOrder.getId());
         * assertTrue(customerOrderRepository.containsEntity(customerOrder));
         * 
         * var id = customerOrder.getId(); var customerOrderUpdate = new CustomerOrder();
         * // TODO fill update data assertTrue(customerOrderRepository.containsKey(id));
         * var customerOrderUpdated = ordersService.updateCustomerOrder(id,
         * customerOrderUpdate); assertTrue(customerOrderUpdated.isPresent());
         * assertTrue(customerOrderRepository.containsEntity(customerOrderUpdated.get()));
         * 
         * assertTrue(customerOrderRepository.containsKey(id));
         * ordersService.deleteCustomerOrder(id);
         * assertFalse(customerOrderRepository.containsKey(id));
         */
    }

    @Test
    @Order(0)
    void getCustomerOrderTest() {
        var id = "1"; // TODO fill id
        var customerOrder = ordersService.getCustomerOrder(id);
        assertTrue(customerOrder.isPresent());
    }

    @Test
    @Order(1)
    void createCustomerOrderTest() {
        var input = new CustomerOrderInput();
        // TODO fill input data
        // input.setOrderTime(Instant.now());
        // input.setStatus(OrderStatus.values()[0]);
        // input.setCustomerDetails(new Customer());
        // input.setRestaurantDetails(new Restaurant());
        // input.setOrderItems(new OrderItemInput());
        var customerOrder = ordersService.createCustomerOrder(input);
        assertNotNull(customerOrder.getId());
        assertTrue(customerOrderRepository.containsEntity(customerOrder));
    }

    @Test
    @Order(2)
    void updateOrderTest() { // TODO: implement this test
    }

    @Test
    @Order(3)
    void updateKitchenStatusTest() { // TODO: implement this test
    }

    @Test
    @Order(4)
    void updateDeliveryStatusTest() { // TODO: implement this test
    }

    @Test
    @Order(5)
    void cancelOrderTest() { // TODO: implement this test
    }

    @Test
    @Order(6)
    void searchOrdersTest() { // TODO: implement this test
    }

}
