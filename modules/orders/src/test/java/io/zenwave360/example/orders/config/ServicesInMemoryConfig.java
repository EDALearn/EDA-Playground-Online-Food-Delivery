package io.zenwave360.example.orders.config;

import io.zenwave360.example.orders.core.implementation.*;
import io.zenwave360.example.orders.core.outbound.events.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/** Services InMemory Config. It can be used standalone or with @SpringBootTest. */
@Configuration
@Profile("in-memory")
public class ServicesInMemoryConfig extends RepositoriesInMemoryConfig {

    protected final EventsProducerInMemoryContext eventsProducerInMemoryContext = new EventsProducerInMemoryContext();

    protected final OrdersServiceImpl ordersService = new OrdersServiceImpl(customerOrderRepository(),
            eventsProducerInMemoryContext.ordersEventsProducer(), null, null);

    @Bean
    public OrdersServiceImpl ordersService() {
        return ordersService;
    }

}
