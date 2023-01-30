package io.zenwave360.example.delivery.config;

import io.zenwave360.example.delivery.core.implementation.*;
import io.zenwave360.example.delivery.core.outbound.events.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/** Services InMemory Config. It can be used standalone or with @SpringBootTest. */
@Configuration
@Profile("in-memory")
public class ServicesInMemoryConfig extends RepositoriesInMemoryConfig {

    protected final EventsProducerInMemoryContext eventsProducerInMemoryContext = new EventsProducerInMemoryContext();

    protected final DeliveryServiceImpl deliveryService = new DeliveryServiceImpl(deliveryRepository(),
            eventsProducerInMemoryContext.deliveryEventsProducer());

    @Bean
    public DeliveryServiceImpl deliveryService() {
        return deliveryService;
    }

}
