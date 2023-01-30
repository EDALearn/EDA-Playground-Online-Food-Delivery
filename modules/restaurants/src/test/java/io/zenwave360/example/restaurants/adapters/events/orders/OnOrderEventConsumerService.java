package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.adapters.commands.IOnOrderEventAtRestaurantsConsumerService;
import io.zenwave360.example.restaurants.adapters.commands.IOnOrderEventAtRestaurantsConsumerService.OrderEventHeaders;
import io.zenwave360.example.restaurants.adapters.events.BaseConsumerTest;
import io.zenwave360.example.restaurants.core.domain.events.OrderEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
* Integration tests for {@link IOnOrderEventAtRestaurantsConsumerService}.
*/
public class OnOrderEventConsumerService extends BaseConsumerTest {

    @Autowired
    public IOnOrderEventAtRestaurantsConsumerService consumerService;

    
    /**
     * Test for onOrderEvent: 
     */
    @Test
    public void onOrderEventTest() {
        OrderEvent payload = new OrderEvent();

        OrderEventHeaders headers = new OrderEventHeaders();

        // invoke the method under test
        consumerService.onOrderEventAtRestaurants(payload, headers);
        // perform your assertions here
    }
    
}
