package io.zenwave360.example.orders.config;

import io.zenwave360.example.orders.core.outbound.mongodb.*;
import io.zenwave360.example.orders.infrastructure.mongodb.inmemory.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

// @Configuration
public class RepositoriesInMemoryConfig {

    protected final CustomerOrderRepository customerOrderRepository = new CustomerOrderRepositoryInMemory();

    @Bean
    @Primary
    public <T extends CustomerOrderRepository> T customerOrderRepository() {
        return (T) customerOrderRepository;
    }

}
