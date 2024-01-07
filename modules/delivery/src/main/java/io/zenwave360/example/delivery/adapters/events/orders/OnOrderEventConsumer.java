package io.zenwave360.example.delivery.adapters.events.orders;

import io.zenwave360.example.delivery.client.orders.events.consumer.IOnOrderEventConsumerService;
import io.zenwave360.example.delivery.client.orders.events.dtos.OrderEvent;
import org.springframework.stereotype.Component;

@Component("delivery_OnOrderEventConsumer")
public class OnOrderEventConsumer extends AbstractBaseConsumer implements IOnOrderEventConsumerService {

    public void onOrderEvent(OrderEvent payload, OrderEventHeaders headers) {
        log.debug("Received command request for onOrderEvent: {} with headers {}", payload, headers);
        // TODO: service.onOrderEvent(mapper.asEntity(payload));
    };

}
