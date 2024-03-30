package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.client.orders.events.consumer.*;
import io.zenwave360.example.restaurants.client.orders.events.consumer.IOnOrderStatusUpdatedConsumerService.OrderStatusUpdatedHeaders;
import io.zenwave360.example.restaurants.client.orders.events.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OnOrderStatusUpdatedConsumerService implements IOnOrderStatusUpdatedConsumerService {

    private Logger log = LoggerFactory.getLogger(getClass());

    private EventsMapper mapper = EventsMapper.INSTANCE;

    // TODO: private EntityService service;

    /** */
    public void onOrderStatusUpdated(OrderStatusUpdated payload, OrderStatusUpdatedHeaders headers) {
        log.debug("Received command request for onOrderStatusUpdated: {} with headers {}", payload, headers);
        // TODO: service.onOrderStatusUpdated(mapper.asEntity(payload));
    };

}
