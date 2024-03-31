package io.zenwave360.example.restaurants.adapters.events.orders;

import io.zenwave360.example.restaurants.adapters.commands.IOnOrderEventConsumerService;
import io.zenwave360.example.restaurants.adapters.events.BaseConsumerTest;
import io.zenwave360.example.restaurants.core.outbound.events.dtos.OrderEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link io.zenwave360.example.restaurants.adapters.commands.IOnOrderEventConsumerService}. */
public class OnOrderEventConsumerService extends BaseConsumerTest {

    @Autowired
    public IOnOrderEventConsumerService consumerService;

    /** Test for onOrderEvent: */
    @Test
    public void onOrderEventTest() {
        OrderEvent payload = new OrderEvent();

        IOnOrderEventConsumerService.OrderEventHeaders headers = new IOnOrderEventConsumerService.OrderEventHeaders();

        // invoke the method under test
        consumerService.onOrderEvent(payload, headers);
        // perform your assertions here
    }

}
