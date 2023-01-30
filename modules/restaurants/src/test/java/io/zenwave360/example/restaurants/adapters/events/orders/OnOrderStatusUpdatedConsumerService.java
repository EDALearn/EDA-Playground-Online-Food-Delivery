package io.zenwave360.example.restaurants.adapters.events.orders;


import io.zenwave360.example.restaurants.adapters.commands.IOnOrderStatusUpdatedAtRestaurantsConsumerService;
import io.zenwave360.example.restaurants.adapters.commands.IOnOrderStatusUpdatedAtRestaurantsConsumerService.OrderStatusUpdatedHeaders;
import io.zenwave360.example.restaurants.adapters.events.BaseConsumerTest;

import io.zenwave360.example.restaurants.core.domain.events.OrderStatusUpdated;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
* Integration tests for {@link io.zenwave360.example.restaurants.adapters.commands.IOnOrderStatusUpdatedAtRestaurantsConsumerService}.
*/
public class OnOrderStatusUpdatedConsumerService extends BaseConsumerTest {

    @Autowired
    public IOnOrderStatusUpdatedAtRestaurantsConsumerService consumerService;

    
    /**
     * Test for onOrderStatusUpdated: 
     */
    @Test
    public void onOrderStatusUpdatedTest() {
        OrderStatusUpdated payload = new OrderStatusUpdated();

        OrderStatusUpdatedHeaders headers = new OrderStatusUpdatedHeaders();

        // invoke the method under test
        consumerService.onOrderStatusUpdatedAtRestaurants(payload, headers);
        // perform your assertions here
    }
    
}
