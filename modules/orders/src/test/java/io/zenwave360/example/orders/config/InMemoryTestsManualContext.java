package io.zenwave360.example.orders.config;

import io.zenwave360.example.orders.core.implementation.*;
import io.zenwave360.example.orders.core.outbound.events.ProducerInMemoryContext;

public class InMemoryTestsManualContext extends InMemoryTestsConfig {

    public static final InMemoryTestsManualContext INSTANCE = new InMemoryTestsManualContext();
    ProducerInMemoryContext producerInMemory = ProducerInMemoryContext.INSTANCE;

    public OrdersServiceImpl ordersService() {
        return new OrdersServiceImpl(customerOrderRepository(), producerInMemory.ordersEventsProducer());
    }

}
