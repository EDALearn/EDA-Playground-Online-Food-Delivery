package io.zenwave360.example.restaurants.adapters.events.orders;


import io.zenwave360.example.restaurants.adapters.commands.IOnOrderEventAtRestaurantsConsumerService;
import io.zenwave360.example.restaurants.core.domain.events.OrderEvent;
import org.springframework.stereotype.Component;

@Component
public class OnOrderEventConsumerService extends AbstractBaseConsumer implements IOnOrderEventAtRestaurantsConsumerService {

    public void onOrderEventAtRestaurants(OrderEvent payload, OrderEventHeaders headers) {
        log.debug("Received command request for onOrderEvent: {} with headers {}", payload, headers);
        var kitchenOrderInput = mapper.asKitchenOrder(payload);
        restaurantOrdersService.createKitchenOrder(kitchenOrderInput);
    };

}
