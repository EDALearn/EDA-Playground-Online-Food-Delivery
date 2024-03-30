package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.adapters.events.BaseConsumerTest;
import io.zenwave360.example.restaurants.client.orders.events.consumer.*;
import io.zenwave360.example.restaurants.client.orders.events.consumer.IOnOrderStatusUpdatedConsumerService.OrderStatusUpdatedHeaders;
import io.zenwave360.example.restaurants.client.orders.events.dtos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link IOnOrderStatusUpdatedConsumerService}. */
public class OnOrderStatusUpdatedConsumerService extends BaseConsumerTest {

    @Autowired
    public IOnOrderStatusUpdatedConsumerService consumerService;

    /** Test for onOrderStatusUpdated: */
    @Test
    public void onOrderStatusUpdatedTest() {
        OrderStatusUpdated payload = new OrderStatusUpdated();

        OrderStatusUpdatedHeaders headers = new OrderStatusUpdatedHeaders();

        // invoke the method under test
        consumerService.onOrderStatusUpdated(payload, headers);
        // perform your assertions here
    }

}
