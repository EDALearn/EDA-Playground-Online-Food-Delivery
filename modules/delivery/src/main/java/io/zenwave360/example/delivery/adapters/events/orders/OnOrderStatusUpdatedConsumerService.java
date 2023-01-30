package io.zenwave360.example.delivery.adapters.events.orders;

import io.zenwave360.example.delivery.adapters.commands.IOnOrderStatusUpdatedAtDeliveryConsumerService;
import io.zenwave360.example.delivery.core.domain.events.OrderStatusUpdated;
import org.springframework.stereotype.Component;

@Component("delivery_OnOrderStatusUpdatedConsumerService")
public class OnOrderStatusUpdatedConsumerService extends AbstractBaseConsumer implements IOnOrderStatusUpdatedAtDeliveryConsumerService {

    public void onOrderStatusUpdated(OrderStatusUpdated payload, OrderStatusUpdatedHeaders headers) {
        log.debug("Received command request for onOrderStatusUpdated: {} with headers {}", payload, headers);
        // TODO: service.onOrderStatusUpdated(mapper.asEntity(payload));
    };

}
