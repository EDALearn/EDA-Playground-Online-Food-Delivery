package io.zenwave360.example.delivery.core.implementation;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.domain.events.*;
import io.zenwave360.example.delivery.core.implementation.mappers.*;
import io.zenwave360.example.delivery.core.inbound.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import io.zenwave360.example.delivery.core.outbound.events.*;
import io.zenwave360.example.delivery.core.outbound.mongodb.*;
import java.math.*;
import java.time.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [Delivery]. */
@Service
@Transactional(readOnly = true)
@lombok.AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final DeliveryServiceMapper deliveryServiceMapper = DeliveryServiceMapper.INSTANCE;

    private final DeliveryRepository deliveryRepository;

    private final EventsMapper eventsMapper = EventsMapper.INSTANCE;

    private final IDeliveryEventsProducer eventsProducer;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public Delivery createDelivery(DeliveryInput input) {
        log.debug("Request createDelivery: {}", input);
        var deliveryAggregate = new DeliveryAggregate();
        deliveryAggregate.createDelivery(input);
        persistAndEmitEvents(deliveryAggregate);
        return deliveryAggregate.getRootEntity();
    }

    public Delivery onOrderStatusUpdated(OrderStatusUpdated input) {
        log.debug("Request onOrderStatusUpdated: {}", input);
        var deliveryAggregate = new DeliveryAggregate();
        deliveryAggregate.onOrderStatusUpdated(input);
        persistAndEmitEvents(deliveryAggregate);
        return deliveryAggregate.getRootEntity();
    }

    @Transactional
    public Delivery updateDeliveryStatus(String id, DeliveryStatusInput input) {
        log.debug("Request updateDeliveryStatus: {} {}", id, input);
        var deliveryAggregate = deliveryRepository.findDeliveryAggregateById(id).orElseThrow();
        deliveryAggregate.updateDeliveryStatus(input);
        persistAndEmitEvents(deliveryAggregate);
        return deliveryAggregate.getRootEntity();
    }

    public Page<Delivery> listDeliveries(Pageable pageable) {
        log.debug("Request listDeliveries: {}", pageable);

        var deliveries = deliveryRepository.findAll(pageable);
        return deliveries;
    }

    private DeliveryAggregate persistAndEmitEvents(DeliveryAggregate deliveryAggregate) {
        var delivery = deliveryRepository.save(deliveryAggregate.getRootEntity());
        deliveryAggregate.getEvents().forEach(event -> {
            if (event instanceof DeliveryStatusUpdated) {
                eventsProducer
                    .onDeliveryStatusUpdated(eventsMapper.asDeliveryStatusUpdated((DeliveryStatusUpdated) event));
            }
        });
        return deliveryAggregate;
    }

}
