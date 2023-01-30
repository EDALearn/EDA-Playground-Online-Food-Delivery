package io.zenwave360.example.delivery.adapters.events.orders;


import io.zenwave360.example.delivery.adapters.commands.IOnOrderEventAtDeliveryConsumerService;

import io.zenwave360.example.delivery.core.domain.events.OrderEvent;
import org.springframework.stereotype.Component;

@Component("delivery_OnOrderEventConsumerService")
public class OnOrderEventConsumerService extends AbstractBaseConsumer implements IOnOrderEventAtDeliveryConsumerService {

    public void onOrderEventAtDelivery(OrderEvent payload, OrderEventHeaders headers) {
        log.debug("Received command request for onOrderEvent: {} with headers {}", payload, headers);
        var deliveryInput = mapper.asDeliveryInput(payload);
        deliveryService.createDelivery(deliveryInput);
    };

}
