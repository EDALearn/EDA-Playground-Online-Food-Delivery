package io.zenwave360.example.delivery.config;

import io.zenwave360.example.delivery.core.implementation.*;

public class InMemoryTestsManualContext extends InMemoryTestsConfig {

    public static final InMemoryTestsManualContext INSTANCE = new InMemoryTestsManualContext();

    public DeliveryServiceImpl deliveryService() {
        return new DeliveryServiceImpl(deliveryRepository());
    }

}
