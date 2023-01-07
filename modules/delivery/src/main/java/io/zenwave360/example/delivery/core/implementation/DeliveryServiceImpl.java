package io.zenwave360.example.delivery.core.implementation;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.domain.events.DeliveryStatus;
import io.zenwave360.example.delivery.core.domain.events.DeliveryStatusUpdated;
import io.zenwave360.example.delivery.core.implementation.mappers.*;
import io.zenwave360.example.delivery.core.inbound.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import io.zenwave360.example.delivery.core.outbound.events.IDeliveryEventsProducer;
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
public class DeliveryServiceImpl implements DeliveryService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final DeliveryMapper deliveryMapper = DeliveryMapper.INSTANCE;

    private final DeliveryRepository deliveryRepository;

    private final IDeliveryEventsProducer eventsProducer;

    /** Constructor. */
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, IDeliveryEventsProducer eventsProducer) {
        this.deliveryRepository = deliveryRepository;
        this.eventsProducer = eventsProducer;
    }

    @Transactional
    @SneakyThrows
    public Delivery createDelivery(DeliveryInput input) {
        log.debug("Request to save Delivery: {}", input);
        var isDeliveryAvailable = true;
        if(isDeliveryAvailable) {
            var delivery = deliveryMapper.update(new Delivery(), input);
            delivery = deliveryRepository.save(delivery);
            var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                    .withDeliveryId(delivery.getId())
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(DeliveryStatus.ACCEPTED);
            // sleep 1 second to avoid race conditions on orders (TB FIXED)
            Thread.sleep(1000);
            eventsProducer.onDeliveryStatusUpdated(deliveryUpdateStatus);
            return delivery;
        } else {
            var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(DeliveryStatus.REJECTED);
            eventsProducer.onDeliveryStatusUpdated(deliveryUpdateStatus);
            return null;
        }
    }

    @Transactional
    public void onOrderStatusUpdated(OrderStatusUpdated input) {
        log.debug("Request onOrderStatusUpdated: {}", input);
        if ("CANCELLED".equals(input.getStatus())) {
            var delivery = deliveryRepository.findByOrderId(input.getOrderId()).orElseThrow();
            delivery.setStatus(DeliveryOrderStatus.CANCELLED);
            deliveryRepository.save(delivery);
            var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                    .withDeliveryId(delivery.getId())
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(DeliveryStatus.CANCELLED);
            eventsProducer.onDeliveryStatusUpdated(deliveryUpdateStatus);
        }
    }

    public Delivery updateDeliveryStatus(String id, DeliveryStatusInput input) {
        log.debug("Request updateDeliveryStatus: {}", id);
        var delivery = deliveryRepository.findById(id).orElseThrow();
        delivery = deliveryMapper.update(delivery, input);
        var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                .withDeliveryId(delivery.getId())
                .withCustomerOrderId(delivery.getOrderId())
                .withStatus(deliveryMapper.asDeliveryStatus(delivery.getStatus()));
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
