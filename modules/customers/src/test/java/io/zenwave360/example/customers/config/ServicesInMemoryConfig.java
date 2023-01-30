package io.zenwave360.example.customers.config;

import io.zenwave360.example.customers.core.implementation.*;
import io.zenwave360.example.customers.core.outbound.events.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/** Services InMemory Config. It can be used standalone or with @SpringBootTest. */
@Configuration
@Profile("in-memory")
public class ServicesInMemoryConfig extends RepositoriesInMemoryConfig {

    protected final EventsProducerInMemoryContext eventsProducerInMemoryContext = new EventsProducerInMemoryContext();

    protected final CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository(),
            eventsProducerInMemoryContext.customerEventsProducer());

    @Bean
    public CustomerServiceImpl customerService() {
        return customerService;
    }

}
