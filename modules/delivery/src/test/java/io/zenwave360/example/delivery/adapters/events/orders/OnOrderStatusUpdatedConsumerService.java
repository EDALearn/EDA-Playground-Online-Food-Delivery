package io.zenwave360.example.delivery.adapters.events.orders;

import io.zenwave360.example.delivery.adapters.events.BaseConsumerTest;
import io.zenwave360.example.delivery.client.orders.events.consumer.*;
import io.zenwave360.example.delivery.client.orders.events.consumer.IOnOrderStatusUpdatedConsumerService.OrderStatusUpdatedHeaders;
import io.zenwave360.example.delivery.client.orders.events.dtos.*;
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
        payload.setId(null);
        payload.setDateTime(null);
        payload.setStatus(null);
        payload.setPreviousStatus(null);

        OrderStatusUpdatedHeaders headers = new OrderStatusUpdatedHeaders();

        // invoke the method under test
        consumerService.onOrderStatusUpdated(payload, headers);
        // perform your assertions here
    }

}
