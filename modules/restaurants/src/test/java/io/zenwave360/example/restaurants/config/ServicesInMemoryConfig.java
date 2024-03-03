package io.zenwave360.example.restaurants.config;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.implementation.*;
import io.zenwave360.example.restaurants.core.outbound.events.*;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/** Services InMemory Config. It can be used standalone or with @SpringBootTest. */
@Configuration
@Profile("in-memory")
public class ServicesInMemoryConfig extends RepositoriesInMemoryConfig {

    protected final EventsProducerInMemoryContext eventsProducerInMemoryContext = new EventsProducerInMemoryContext();

    protected final RestaurantBackOfficeServiceImpl restaurantBackOfficeService = new RestaurantBackOfficeServiceImpl(
            restaurantRepository(), menuItemRepository(),
            eventsProducerInMemoryContext.restaurantBackOfficeEventsProducer());

    protected final RestaurantOrdersServiceImpl restaurantOrdersService = new RestaurantOrdersServiceImpl(
            kitchenOrderRepository(), eventsProducerInMemoryContext.restaurantOrdersEventsProducer());

    @Bean
    public RestaurantBackOfficeServiceImpl restaurantBackOfficeService() {
        return restaurantBackOfficeService;
    }

    @Bean
    public RestaurantOrdersServiceImpl restaurantOrdersService() {
        return restaurantOrdersService;
    }

    public void reloadTestData() {
        var testDataLoader = new TestDataLoader(List.of(Restaurant.class, Address.class, MenuItem.class,
                KitchenOrder.class, CustomerDetails.class, CustomerAddress.class));
    }

}
