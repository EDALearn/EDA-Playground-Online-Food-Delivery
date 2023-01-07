package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.core.inbound.RestaurantOrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseConsumer {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected RestaurantOrdersService restaurantOrdersService;
    protected EventsMapper mapper = EventsMapper.INSTANCE;

    @Autowired
    public void setRestaurantOrdersService(RestaurantOrdersService restaurantOrdersService) {
        this.restaurantOrdersService = restaurantOrdersService;
    }

}
