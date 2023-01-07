package io.zenwave360.example.delivery.config;


import io.zenwave360.example.delivery.core.implementation.*;
import io.zenwave360.example.delivery.core.outbound.events.ProducerInMemoryContext;

public class InMemoryTestsManualContext extends InMemoryTestsConfig {

    public static final InMemoryTestsManualContext INSTANCE = new InMemoryTestsManualContext();
    private static final ProducerInMemoryContext producerContext = ProducerInMemoryContext.INSTANCE;

    public DeliveryServiceImpl deliveryService() {
        return new DeliveryServiceImpl(deliveryRepository(), producerContext.deliveryEventsProducer());
    }

}
