package io.zenwave360.example.restaurants.core.implementation;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.domain.events.KitchenOrderStatusUpdated;
import io.zenwave360.example.restaurants.core.implementation.mappers.*;
import io.zenwave360.example.restaurants.core.inbound.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import io.zenwave360.example.restaurants.core.outbound.events.IRestaurantOrdersEventsProducer;
import io.zenwave360.example.restaurants.core.outbound.events.RestaurantOrdersEventsProducer;
import io.zenwave360.example.restaurants.core.outbound.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [KitchenOrder]. */
@Service
@Transactional(readOnly = true)
public class RestaurantOrdersServiceImpl implements RestaurantOrdersService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final KitchenOrderMapper kitchenOrderMapper = KitchenOrderMapper.INSTANCE;

    private final KitchenOrderRepository kitchenOrderRepository;

    private final IRestaurantOrdersEventsProducer eventsProducer;

    /** Constructor. */
    public RestaurantOrdersServiceImpl(KitchenOrderRepository kitchenOrderRepository, RestaurantOrdersEventsProducer eventsProducer) {
        this.kitchenOrderRepository = kitchenOrderRepository;
        this.eventsProducer = eventsProducer;
    }

    @Transactional
    public KitchenOrder createKitchenOrder(KitchenOrderInput input) {
        log.debug("Request to save KitchenOrder: {}", input);
        var isKitchenAvailability = true;
        if(isKitchenAvailability) {
            var kitchenOrder = kitchenOrderMapper.update(new KitchenOrder(), input);
            kitchenOrder = kitchenOrderRepository.save(kitchenOrder);
            var kitchenOrderUpdateStatus = new KitchenOrderStatusUpdated() //
                .withKitchenOrderId(kitchenOrder.getId())
                .withCustomerOrderId(input.getOrderId())
                .withStatus(io.zenwave360.example.restaurants.core.domain.events.KitchenOrderStatus.ACCEPTED);
            eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderUpdateStatus);
            return kitchenOrder;
        } else {
            var kitchenOrderUpdateStatus = new KitchenOrderStatusUpdated() //
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(io.zenwave360.example.restaurants.core.domain.events.KitchenOrderStatus.REJECTED);
            eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderUpdateStatus);
            return null;
        }
    }

    @Transactional
    public void onOrderStatusUpdated(OrderStatusUpdated input) {
        log.debug("Request onOrderStatusUpdated: {}", input);
        if ("CANCELLED".equals(input.getStatus())) {
            var kitchenOrder = kitchenOrderRepository.findByOrderId(input.getOrderId()).orElseThrow();
            kitchenOrder.setStatus(KitchenOrderStatus.CANCELLED);
            kitchenOrderRepository.save(kitchenOrder);
            var kitchenOrderUpdateStatus = new KitchenOrderStatusUpdated() //
                    .withKitchenOrderId(kitchenOrder.getId())
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(io.zenwave360.example.restaurants.core.domain.events.KitchenOrderStatus.CANCELLED);
            eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderUpdateStatus);
        }
    }

    public KitchenOrder updateKitchenOrderStatus(String id, KitchenOrderStatusInput input) {
        log.debug("Request updateKitchenOrderStatus: {}", id);
        var kitchenOrder = kitchenOrderRepository.findById(id).orElseThrow();
        kitchenOrder = kitchenOrderMapper.update(kitchenOrder, input);
        var kitchenOrderUpdateStatus = new KitchenOrderStatusUpdated() //
                .withKitchenOrderId(kitchenOrder.getId())
                .withCustomerOrderId(kitchenOrder.getOrderId())
                .withStatus(kitchenOrderMapper.asKitchenOrderStatus(kitchenOrder.getStatus()));
        eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderUpdateStatus);
        kitchenOrder = kitchenOrderRepository.save(kitchenOrder);
        return kitchenOrder;
    }

    public Page<KitchenOrder> searchKitchenOrders(KitchenOrdersFilter input, Pageable pageable) {
        log.debug("Request to search KitchenOrders: {} - {}", input, pageable);
        // TODO implement this search by criteria
        var page = kitchenOrderRepository.findAll(pageable);
        return page;
    }

}
