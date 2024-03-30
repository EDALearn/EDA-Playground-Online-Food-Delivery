package io.zenwave360.example.orders.adapters.events.restaurants;

import io.zenwave360.example.orders.adapters.events.BaseConsumerTest;
import io.zenwave360.example.orders.client.restaurants.events.consumer.*;
import io.zenwave360.example.orders.client.restaurants.events.consumer.IOnRestaurantEventConsumerService.RestaurantEventHeaders;
import io.zenwave360.example.orders.client.restaurants.events.dtos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link IOnRestaurantEventConsumerService}. */
public class OnRestaurantEventConsumerService extends BaseConsumerTest {

    @Autowired
    public IOnRestaurantEventConsumerService consumerService;

    /** Test for onRestaurantEvent: */
    @Test
    public void onRestaurantEventTest() {
        RestaurantEvent payload = new RestaurantEvent();
        payload.setName(null);
        payload.setPhone(null);
        payload.setAddress(null);
        payload.setId(null);

        RestaurantEventHeaders headers = new RestaurantEventHeaders();

        // invoke the method under test
        consumerService.onRestaurantEvent(payload, headers);
        // perform your assertions here
    }

}
