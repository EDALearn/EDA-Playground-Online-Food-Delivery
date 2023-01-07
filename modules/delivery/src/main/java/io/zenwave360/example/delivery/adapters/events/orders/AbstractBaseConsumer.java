package io.zenwave360.example.delivery.adapters.events.orders;

import io.zenwave360.example.delivery.core.inbound.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseConsumer {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected DeliveryService deliveryService;
    protected EventsMapper mapper = EventsMapper.INSTANCE;

    @Autowired
    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

}
