package io.zenwave360.example.orders.adapters.events.delivery;

import io.zenwave360.example.orders.client.delivery.events.consumer.*;
import io.zenwave360.example.orders.client.delivery.events.consumer.IOnDeliveryStatusUpdatedConsumerService.DeliveryStatusUpdatedHeaders;
import io.zenwave360.example.orders.client.delivery.events.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OnDeliveryStatusUpdatedConsumerService implements IOnDeliveryStatusUpdatedConsumerService {

    private Logger log = LoggerFactory.getLogger(getClass());

    private EventsMapper mapper = EventsMapper.INSTANCE;

    // TODO: private EntityService service;

    /** */
    public void onDeliveryStatusUpdated(DeliveryStatusUpdated payload, DeliveryStatusUpdatedHeaders headers) {
        log.debug("Received command request for onDeliveryStatusUpdated: {} with headers {}", payload, headers);
        // TODO: service.onDeliveryStatusUpdated(mapper.asEntity(payload));
    };

}
