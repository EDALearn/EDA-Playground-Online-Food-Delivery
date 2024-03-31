package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.adapters.commands.IOnOrderEventConsumerService;
import io.zenwave360.example.restaurants.core.outbound.events.dtos.OrderEvent;
import org.springframework.stereotype.Component;

@Component
public class OnOrderEventConsumerService extends AbstractBaseConsumer implements IOnOrderEventConsumerService {

    public void onOrderEvent(OrderEvent payload, OrderEventHeaders headers) {
        log.debug("Received command request for onOrderEvent: {} with headers {}", payload, headers);
        var kitchenOrderInput = mapper.asKitchenOrder(payload);
        restaurantOrdersService.createKitchenOrder(kitchenOrderInput);
    };

}
