package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.client.orders.events.consumer.*;
import io.zenwave360.example.restaurants.client.orders.events.dtos.*;
import org.springframework.stereotype.Component;

@Component
public class OnOrderStatusUpdatedConsumer extends AbstractBaseConsumer implements IOnOrderStatusUpdatedConsumerService {

    public void onOrderStatusUpdated(OrderStatusUpdated payload, OrderStatusUpdatedHeaders headers) {
        log.debug("Received command request for onOrderStatusUpdated: {} with headers {}", payload, headers);
        // TODO: service.onOrderStatusUpdated(mapper.asEntity(payload));
    };

}
