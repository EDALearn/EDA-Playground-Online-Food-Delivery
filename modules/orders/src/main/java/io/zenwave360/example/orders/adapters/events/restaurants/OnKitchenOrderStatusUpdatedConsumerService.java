package io.zenwave360.example.orders.adapters.events.restaurants;

import io.zenwave360.example.orders.client.restaurants.events.consumer.*;
import io.zenwave360.example.orders.client.restaurants.events.consumer.IOnKitchenOrderStatusUpdatedConsumerService.KitchenOrderStatusUpdatedHeaders;
import io.zenwave360.example.orders.client.restaurants.events.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OnKitchenOrderStatusUpdatedConsumerService implements IOnKitchenOrderStatusUpdatedConsumerService {

    private Logger log = LoggerFactory.getLogger(getClass());

    private EventsMapper mapper = EventsMapper.INSTANCE;

    // TODO: private EntityService service;

    /** */
    public void onKitchenOrderStatusUpdated(KitchenOrderStatusUpdated payload,
            KitchenOrderStatusUpdatedHeaders headers) {
        log.debug("Received command request for onKitchenOrderStatusUpdated: {} with headers {}", payload, headers);
        // TODO: service.onKitchenOrderStatusUpdated(mapper.asEntity(payload));
    };

}
