package io.zenwave360.example.delivery.adapters.events.orders;

import io.zenwave360.example.delivery.adapters.events.BaseConsumerTest;
import io.zenwave360.example.delivery.client.orders.events.consumer.*;
import io.zenwave360.example.delivery.client.orders.events.consumer.IOnDeliveryStatusUpdatedConsumerService.DeliveryStatusUpdatedHeaders;
import io.zenwave360.example.delivery.client.orders.events.dtos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link IOnDeliveryStatusUpdatedConsumerService}. */
public class OnDeliveryStatusUpdatedConsumerService extends BaseConsumerTest {

    @Autowired
    public IOnDeliveryStatusUpdatedConsumerService consumerService;

    /** Test for onDeliveryStatusUpdated: */
    @Test
    public void onDeliveryStatusUpdatedTest() {
        DeliveryStatusUpdated payload = new DeliveryStatusUpdated();
        payload.setCustomerOrderId(null);
        payload.setDeliveryId(null);
        payload.setStatus(null);
        payload.setMessage(null);

        DeliveryStatusUpdatedHeaders headers = new DeliveryStatusUpdatedHeaders();

        // invoke the method under test
        consumerService.onDeliveryStatusUpdated(payload, headers);
        // perform your assertions here
    }

}
