package io.zenwave360.example.orders.config;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.implementation.*;
import io.zenwave360.example.orders.core.outbound.events.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/** Services InMemory Config. It can be used standalone or with @SpringBootTest. */
@Configuration
@Profile("in-memory")
public class ServicesInMemoryConfig extends RepositoriesInMemoryConfig {

    protected final EventsProducerInMemoryContext eventsProducerInMemoryContext = new EventsProducerInMemoryContext();

    private ApplicationEventPublisher applicationEventPublisher = new ApplicationEventPublisher() {
        @Override
        public void publishEvent(Object event) {
            publishedEvents.add(event);
        }
    };

    protected final OrdersServiceImpl ordersService = new OrdersServiceImpl(customerOrderRepository(),
            eventsProducerInMemoryContext.ordersEventsProducer(), null, null, applicationEventPublisher);

    @Bean
    public OrdersServiceImpl ordersService() {
        return ordersService;
    }

    public void reloadTestData() {
        var testDataLoader = new TestDataLoader(
                List.of(CustomerOrder.class, Customer.class, Address.class, Restaurant.class, OrderItemInput.class));
    }

    public EventsProducerInMemoryContext getEventsProducerInMemoryContext() {
        return eventsProducerInMemoryContext;
    }

    private List<Object> publishedEvents = new ArrayList<>();

    public List<Object> getPublishedEvents() {
        return publishedEvents;
    }

}
