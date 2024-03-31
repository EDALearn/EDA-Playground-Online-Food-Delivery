package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.adapters.commands.IOnOrderStatusUpdatedConsumerService;
import io.zenwave360.example.restaurants.adapters.events.BaseConsumerTest;
import io.zenwave360.example.restaurants.core.outbound.events.dtos.OrderStatusUpdated;
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

        IOnOrderStatusUpdatedConsumerService.OrderStatusUpdatedHeaders headers = new IOnOrderStatusUpdatedConsumerService.OrderStatusUpdatedHeaders();

        // invoke the method under test
        consumerService.onOrderStatusUpdated(payload, headers);
        // perform your assertions here
    }

}
