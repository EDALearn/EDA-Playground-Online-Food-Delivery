package io.zenwave360.example.delivery.core.implementation;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.implementation.mappers.*;
import io.zenwave360.example.delivery.core.inbound.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import io.zenwave360.example.delivery.core.outbound.mongodb.*;
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

    /** Constructor. */
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    public Delivery createDelivery(DeliveryInput input) {
        log.debug("Request to save Delivery: {}", input);
        var delivery = deliveryMapper.update(new Delivery(), input);
        delivery = deliveryRepository.save(delivery);
        return delivery;
    }

    @Transactional
    public Delivery onOrderStatusUpdated(String id, OrderStatusUpdated input) {
        log.debug("Request onOrderStatusUpdated: {} {}", id, input);
        var delivery = deliveryRepository.findById(id).orElseThrow();
        // TODO: implement this method
        return delivery;
    }

    public Delivery updateDeliveryStatus(String id, DeliveryStatusInput input) {
        log.debug("Request updateDeliveryStatus: {}", id);
        var delivery = deliveryRepository.findById(id).orElseThrow();
        delivery = deliveryMapper.update(delivery, input);
        // TODO: implement this method
        delivery = deliveryRepository.save(delivery);
        return delivery;
    }

    public Page<Delivery> listDeliveries(Pageable pageable) {
        log.debug("Request list of Deliveries: {}", pageable);
        var page = deliveryRepository.findAll(pageable);
        return page;
    }

}
