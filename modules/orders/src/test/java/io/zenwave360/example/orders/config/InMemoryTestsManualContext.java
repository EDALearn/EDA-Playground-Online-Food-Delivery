package io.zenwave360.example.orders.config;

import io.zenwave360.example.orders.core.implementation.*;

public class InMemoryTestsManualContext extends InMemoryTestsConfig {

    public static final InMemoryTestsManualContext INSTANCE = new InMemoryTestsManualContext();

    public OrdersServiceImpl ordersService() {
        return new OrdersServiceImpl(customerOrderRepository());
    }

}
