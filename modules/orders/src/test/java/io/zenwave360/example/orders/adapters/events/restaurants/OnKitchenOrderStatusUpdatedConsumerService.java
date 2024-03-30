package io.zenwave360.example.orders.adapters.events.restaurants;

import io.zenwave360.example.orders.adapters.events.BaseConsumerTest;
import io.zenwave360.example.orders.client.restaurants.events.consumer.*;
import io.zenwave360.example.orders.client.restaurants.events.consumer.IOnKitchenOrderStatusUpdatedConsumerService.KitchenOrderStatusUpdatedHeaders;
import io.zenwave360.example.orders.client.restaurants.events.dtos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link IOnKitchenOrderStatusUpdatedConsumerService}. */
public class OnKitchenOrderStatusUpdatedConsumerService extends BaseConsumerTest {

    @Autowired
    public IOnKitchenOrderStatusUpdatedConsumerService consumerService;

    /** Test for onKitchenOrderStatusUpdated: */
    @Test
    public void onKitchenOrderStatusUpdatedTest() {
        KitchenOrderStatusUpdated payload = new KitchenOrderStatusUpdated();
        payload.setCustomerOrderId(null);
        payload.setKitchenOrderId(null);
        payload.setStatus(null);
        payload.setMessage(null);

        KitchenOrderStatusUpdatedHeaders headers = new KitchenOrderStatusUpdatedHeaders();

        // invoke the method under test
        consumerService.onKitchenOrderStatusUpdated(payload, headers);
        // perform your assertions here
    }

}
