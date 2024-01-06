package io.zenwave360.example.delivery.config;

import io.zenwave360.example.delivery.core.outbound.mongodb.*;
import io.zenwave360.example.delivery.infrastructure.mongodb.inmemory.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

// @Configuration
public class InMemoryTestsConfig {

    private final DeliveryRepository deliveryRepository = new DeliveryRepositoryInMemory();

    @Bean
    @Primary
    public <T extends DeliveryRepository> T deliveryRepository() {
        return (T) deliveryRepository;
    }

}
