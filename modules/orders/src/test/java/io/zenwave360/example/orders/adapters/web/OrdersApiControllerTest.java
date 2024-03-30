package io.zenwave360.example.orders.adapters.web;

import io.zenwave360.example.orders.adapters.web.model.*;
import io.zenwave360.example.orders.config.ServicesInMemoryConfig;
import java.math.*;
import java.time.*;
import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Test controller for OrdersApiController. */
public class OrdersApiControllerTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ServicesInMemoryConfig context = new ServicesInMemoryConfig();

    OrdersApiController controller = new OrdersApiController().setOrdersService(context.ordersService());

    @BeforeEach
    void setUp() {
        context.reloadTestData();
    }

    @Test
    public void getCustomerOrderTest() {
        String orderId = null;
        var response = controller.getCustomerOrder(orderId);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void updateOrderTest() {
        String orderId = null;
        CustomerOrderInputDTO reqBody = null;
        var response = controller.updateOrder(orderId, reqBody);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void createOrderTest() {
        CustomerOrderInputDTO reqBody = null;
        var response = controller.createOrder(reqBody);
        Assertions.assertEquals(201, response.getStatusCode().value());
    }

    @Test
    public void cancelOrderTest() {
        String orderId = null;
        CancelOrderInputDTO reqBody = null;
        var response = controller.cancelOrder(orderId, reqBody);
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void searchOrdersTest() {
        OrdersFilterDTO reqBody = null;
        var response = controller.searchOrders(reqBody);
        Assertions.assertEquals(201, response.getStatusCode().value());
    }

}
