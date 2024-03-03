package io.zenwave360.example.delivery.adapters.events.orders;

import io.zenwave360.example.delivery.client.orders.events.consumer.IOnOrderStatusUpdatedConsumerService;
import io.zenwave360.example.delivery.client.orders.events.dtos.OrderStatusUpdated;
import org.springframework.stereotype.Component;

@Component("delivery_OnOrderStatusUpdatedConsumerService")
public class OnOrderStatusUpdatedConsumerService extends AbstractBaseConsumer implements IOnOrderStatusUpdatedConsumerService {

    public void onOrderStatusUpdated(OrderStatusUpdated payload, OrderStatusUpdatedHeaders headers) {
        log.debug("Received command request for onOrderStatusUpdated: {} with headers {}", payload, headers);
        deliveryService.onOrderStatusUpdated(payload.getId(), mapper.orderStatusUpdated(payload));
    };

}
