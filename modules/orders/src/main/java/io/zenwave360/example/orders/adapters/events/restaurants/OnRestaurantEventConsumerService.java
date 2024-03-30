package io.zenwave360.example.orders.adapters.events.restaurants;

import io.zenwave360.example.orders.client.restaurants.events.consumer.*;
import io.zenwave360.example.orders.client.restaurants.events.consumer.IOnRestaurantEventConsumerService.RestaurantEventHeaders;
import io.zenwave360.example.orders.client.restaurants.events.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OnRestaurantEventConsumerService implements IOnRestaurantEventConsumerService {

    private Logger log = LoggerFactory.getLogger(getClass());

    private EventsMapper mapper = EventsMapper.INSTANCE;

    // TODO: private EntityService service;

    /** */
    public void onRestaurantEvent(RestaurantEvent payload, RestaurantEventHeaders headers) {
        log.debug("Received command request for onRestaurantEvent: {} with headers {}", payload, headers);
        // TODO: service.onRestaurantEvent(mapper.asEntity(payload));
    };

}
