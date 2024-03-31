package io.zenwave360.example.delivery.adapters.events.orders;

import io.zenwave360.example.delivery.adapters.commands.IOnOrderStatusUpdatedConsumerService;
import io.zenwave360.example.delivery.core.outbound.events.dtos.OrderStatusUpdated;
import org.springframework.stereotype.Component;

@Component("delivery_OnOrderStatusUpdatedConsumerService")
public class OnOrderStatusUpdatedConsumerService extends AbstractBaseConsumer implements IOnOrderStatusUpdatedConsumerService {

    public void onOrderStatusUpdated(OrderStatusUpdated payload, OrderStatusUpdatedHeaders headers) {
        log.debug("Received command request for onOrderStatusUpdated: {} with headers {}", payload, headers);
        deliveryService.onOrderStatusUpdated(mapper.orderStatusUpdated(payload));
    };

}
