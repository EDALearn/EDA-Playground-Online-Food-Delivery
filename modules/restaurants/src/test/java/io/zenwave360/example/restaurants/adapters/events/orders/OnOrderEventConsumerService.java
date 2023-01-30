package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.client.orders.events.dtos.*;
import io.zenwave360.example.restaurants.client.orders.events.consumer.*;
import io.zenwave360.example.restaurants.client.orders.events.consumer.IOnOrderEventConsumerService.OrderEventHeaders;
import io.zenwave360.example.restaurants.adapters.events.BaseConsumerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
* Integration tests for {@link IOnOrderEventConsumerService}.
*/
public class OnOrderEventConsumerService extends BaseConsumerTest {

    @Autowired
    public IOnOrderEventConsumerService consumerService;

    
    /**
     * Test for onOrderEvent: 
     */
    @Test
    public void onOrderEventTest() {
        OrderEvent payload = new OrderEvent();

        OrderEventHeaders headers = new OrderEventHeaders();

        // invoke the method under test
        consumerService.onOrderEvent(payload, headers);
        // perform your assertions here
    }
    
}
