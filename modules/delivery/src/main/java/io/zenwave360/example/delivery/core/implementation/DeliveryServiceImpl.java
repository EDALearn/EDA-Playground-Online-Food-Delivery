package io.zenwave360.example.delivery.core.implementation;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.domain.events.DeliveryOrderStatus;
import io.zenwave360.example.delivery.core.domain.events.DeliveryStatusUpdated;
import io.zenwave360.example.delivery.core.implementation.mappers.*;
import io.zenwave360.example.delivery.core.inbound.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import io.zenwave360.example.delivery.core.outbound.events.*;
import io.zenwave360.example.delivery.core.outbound.mongodb.*;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Transactional
    @SneakyThrows
    public Delivery createDelivery(DeliveryInput input) {
        log.debug("Request to save Delivery: {}", input);
        var isDeliveryAvailable = true;
        if(isDeliveryAvailable) {
            var delivery = deliveryServiceMapper.update(new Delivery(), input);
            delivery = deliveryRepository.save(delivery);
            var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                    .withDeliveryId(delivery.getId())
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(DeliveryOrderStatus.ACCEPTED);
            // sleep 1 second to avoid race conditions on orders (TB FIXED)
            Thread.sleep(1000);
            eventsProducer.onDeliveryStatusUpdated(deliveryUpdateStatus);
            return delivery;
        } else {
            var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(DeliveryOrderStatus.REJECTED);
            eventsProducer.onDeliveryStatusUpdated(deliveryUpdateStatus);
            return null;
        }
    }

    @Transactional
    public Delivery onOrderStatusUpdated(String id, OrderStatusUpdated input) {
        log.debug("Request onOrderStatusUpdated: {}", input);
        var delivery = deliveryRepository.findByOrderId(id).orElseThrow();
        if ("CANCELLED".equals(input.getStatus())) {
            delivery.setStatus(io.zenwave360.example.delivery.core.domain.DeliveryOrderStatus.CANCELLED);
            deliveryRepository.save(delivery);
            var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                    .withDeliveryId(delivery.getId())
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(DeliveryOrderStatus.CANCELLED);
            eventsProducer.onDeliveryStatusUpdated(deliveryUpdateStatus);
        }
        return delivery;
    }

    public Delivery updateDeliveryStatus(String id, DeliveryStatusInput input) {
        log.debug("Request updateDeliveryStatus: {}", id);
        var delivery = deliveryRepository.findById(id).orElseThrow();
        delivery = deliveryServiceMapper.update(delivery, input);
        var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                .withDeliveryId(delivery.getId())
                .withCustomerOrderId(delivery.getOrderId())
                .withStatus(deliveryServiceMapper.asDeliveryStatus(delivery.getStatus()));
        eventsProducer.onDeliveryStatusUpdated(deliveryUpdateStatus);
        delivery = deliveryRepository.save(delivery);
        return delivery;
    }

    public Page<Delivery> listDeliveries(Pageable pageable) {
        log.debug("Request list of Deliveries: {}", pageable);
        var page = deliveryRepository.findAll(pageable);
        return page;
    }

}
