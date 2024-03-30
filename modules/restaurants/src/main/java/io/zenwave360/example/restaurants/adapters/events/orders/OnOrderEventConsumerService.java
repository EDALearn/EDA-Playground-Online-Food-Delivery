package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.client.orders.events.consumer.*;
import io.zenwave360.example.restaurants.client.orders.events.consumer.IOnOrderEventConsumerService.OrderEventHeaders;
import io.zenwave360.example.restaurants.client.orders.events.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OnOrderEventConsumerService implements IOnOrderEventConsumerService {

    private Logger log = LoggerFactory.getLogger(getClass());

    private EventsMapper mapper = EventsMapper.INSTANCE;

    // TODO: private EntityService service;

    /** */
    public void onOrderEvent(OrderEvent payload, OrderEventHeaders headers) {
        log.debug("Received command request for onOrderEvent: {} with headers {}", payload, headers);
        // TODO: service.onOrderEvent(mapper.asEntity(payload));
    };

}
