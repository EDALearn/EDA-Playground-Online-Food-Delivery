package io.zenwave360.example.restaurants.config;

import io.zenwave360.example.restaurants.core.implementation.*;
import io.zenwave360.example.restaurants.core.outbound.events.ProducerInMemoryContext;

public class InMemoryTestsManualContext extends InMemoryTestsConfig {

    public static final InMemoryTestsManualContext INSTANCE = new InMemoryTestsManualContext();
    ProducerInMemoryContext producerContext = ProducerInMemoryContext.INSTANCE;

    public RestaurantBackOfficeServiceImpl restaurantBackOfficeService() {
        return new RestaurantBackOfficeServiceImpl(restaurantRepository(), menuItemRepository());
    }

    public RestaurantOrdersServiceImpl restaurantOrdersService() {
        return new RestaurantOrdersServiceImpl(kitchenOrderRepository(), producerContext.restaurantOrdersEventsProducer());
    }

}
