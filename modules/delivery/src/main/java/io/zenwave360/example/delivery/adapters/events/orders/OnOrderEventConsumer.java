package io.zenwave360.example.delivery.adapters.events.orders;


import io.zenwave360.example.delivery.adapters.commands.IOnOrderEventConsumerService;
import io.zenwave360.example.delivery.core.domain.events.OrderEvent;
import org.springframework.stereotype.Component;

@Component("delivery_OnOrderEventConsumer")
public class OnOrderEventConsumer extends AbstractBaseConsumer implements IOnOrderEventConsumerService {

    public void onOrderEvent(OrderEvent payload, OrderEventHeaders headers) {
        log.debug("Received command request for onOrderEvent: {} with headers {}", payload, headers);
        var deliveryInput = mapper.asDeliveryInput(payload);
        deliveryService.createDelivery(deliveryInput);
    };

}
