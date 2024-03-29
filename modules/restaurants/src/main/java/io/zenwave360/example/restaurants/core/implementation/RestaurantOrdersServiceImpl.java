package io.zenwave360.example.restaurants.core.implementation;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.outbound.events.dtos.KitchenOrderStatusUpdated;
import io.zenwave360.example.restaurants.core.implementation.mappers.*;
import io.zenwave360.example.restaurants.core.inbound.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import io.zenwave360.example.restaurants.core.outbound.events.*;
import io.zenwave360.example.restaurants.core.outbound.mongodb.*;
import java.math.*;
import java.time.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [KitchenOrder]. */
@Service
@Transactional(readOnly = true)
@lombok.AllArgsConstructor
public class RestaurantOrdersServiceImpl implements RestaurantOrdersService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final RestaurantOrdersServiceMapper restaurantOrdersServiceMapper = RestaurantOrdersServiceMapper.INSTANCE;

    private final KitchenOrderRepository kitchenOrderRepository;

    private final EventsMapper eventsMapper = EventsMapper.INSTANCE;

    private final IRestaurantOrdersEventsProducer eventsProducer;

    @Transactional
    public KitchenOrder createKitchenOrder(KitchenOrderInput input) {
        log.debug("Request to save KitchenOrder: {}", input);
        var kitchenOrder = restaurantOrdersServiceMapper.update(new KitchenOrder(), input);
        kitchenOrder.setStatus(KitchenOrderStatus.ACCEPTED);
        kitchenOrder = kitchenOrderRepository.save(kitchenOrder);
        var kitchenOrderUpdateStatus = new KitchenOrderStatusUpdated() //
                .withKitchenOrderId(kitchenOrder.getId())
                .withCustomerOrderId(input.getOrderId())
                .withStatus(io.zenwave360.example.restaurants.core.outbound.events.dtos.KitchenOrderStatus.ACCEPTED);
        eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderUpdateStatus);
        return kitchenOrder;
    }

    @Transactional
    public void onOrderStatusUpdated(OrderStatusUpdated input) {
        log.debug("Request onOrderStatusUpdated: {}", input);
        if ("CONFIRMED".equals(input.getStatus())) {
            var kitchenOrder = kitchenOrderRepository.findByOrderId(input.getOrderId()).orElseThrow();
            kitchenOrder.setStatus(KitchenOrderStatus.IN_PROGRESS);
            kitchenOrderRepository.save(kitchenOrder);
            var kitchenOrderUpdateStatus = new KitchenOrderStatusUpdated() //
                    .withKitchenOrderId(kitchenOrder.getId())
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(io.zenwave360.example.restaurants.core.outbound.events.dtos.KitchenOrderStatus.IN_PROGRESS);
            eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderUpdateStatus);
        }
        if ("CANCELLED".equals(input.getStatus())) {
            var kitchenOrder = kitchenOrderRepository.findByOrderId(input.getOrderId()).orElseThrow();
            kitchenOrder.setStatus(KitchenOrderStatus.CANCELLED);
            kitchenOrderRepository.save(kitchenOrder);
            var kitchenOrderUpdateStatus = new KitchenOrderStatusUpdated() //
                    .withKitchenOrderId(kitchenOrder.getId())
                    .withCustomerOrderId(input.getOrderId())
                    .withStatus(io.zenwave360.example.restaurants.core.outbound.events.dtos.KitchenOrderStatus.CANCELLED);
            eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderUpdateStatus);
        }
    }

    public KitchenOrder updateKitchenOrderStatus(String id, KitchenOrderStatusInput input) {
        log.debug("Request updateKitchenOrderStatus: {}", id);
        var kitchenOrder = kitchenOrderRepository.findById(id).orElseThrow();
        kitchenOrder = restaurantOrdersServiceMapper.update(kitchenOrder, input);
        var kitchenOrderUpdateStatus = new KitchenOrderStatusUpdated() //
                .withKitchenOrderId(kitchenOrder.getId())
                .withCustomerOrderId(kitchenOrder.getOrderId())
                .withStatus(restaurantOrdersServiceMapper.asKitchenOrderStatus(kitchenOrder.getStatus()));
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
