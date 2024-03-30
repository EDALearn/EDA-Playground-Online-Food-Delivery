package io.zenwave360.example.restaurants.core.implementation;

import io.zenwave360.example.restaurants.core.domain.*;
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
import org.springframework.context.ApplicationEventPublisher;
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

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public KitchenOrder createKitchenOrder(KitchenOrderInput input) {
        log.debug("[CRUD] Request to save KitchenOrder: {}", input);
        var kitchenOrder = restaurantOrdersServiceMapper.update(new KitchenOrder(), input);
        kitchenOrder = kitchenOrderRepository.save(kitchenOrder);
        // emit events
        var kitchenOrderStatusUpdated = eventsMapper.asKitchenOrderStatusUpdated(kitchenOrder);
        eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderStatusUpdated);
        return kitchenOrder;
    }

    public void onOrderStatusUpdated(OrderStatusUpdated input) {
        log.debug("Request onOrderStatusUpdated: {}", input);

        var kitchenOrder = new KitchenOrder();
        // TODO: implement this method
        // emit events
        var kitchenOrderStatusUpdated = eventsMapper.asKitchenOrderStatusUpdated(input);
        eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderStatusUpdated);
    }

    @Transactional
    public KitchenOrder updateKitchenOrderStatus(String id, KitchenOrderStatusInput input) {
        log.debug("Request updateKitchenOrderStatus: {} {}", id, input);

        var kitchenOrder = kitchenOrderRepository.findById(id).map(existingKitchenOrder -> {
            return restaurantOrdersServiceMapper.update(existingKitchenOrder, input);
        }).map(kitchenOrderRepository::save).orElseThrow();
        // emit events
        var kitchenOrderStatusUpdated = eventsMapper.asKitchenOrderStatusUpdated(kitchenOrder);
        eventsProducer.onKitchenOrderStatusUpdated(kitchenOrderStatusUpdated);
        return kitchenOrder;
    }

    public Page<KitchenOrder> searchKitchenOrders(KitchenOrdersFilter input, Pageable pageable) {
        log.debug("Request searchKitchenOrders: {} {}", input, pageable);

        var kitchenOrders = kitchenOrderRepository.findAll(pageable);
        return kitchenOrders;
    }

}
