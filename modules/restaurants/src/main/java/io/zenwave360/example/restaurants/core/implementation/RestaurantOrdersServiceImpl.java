package io.zenwave360.example.restaurants.core.implementation;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.implementation.mappers.*;
import io.zenwave360.example.restaurants.core.inbound.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
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

    /** Constructor. */
    public RestaurantOrdersServiceImpl(KitchenOrderRepository kitchenOrderRepository) {
        this.kitchenOrderRepository = kitchenOrderRepository;
    }

    @Transactional
    public KitchenOrder createKitchenOrder(KitchenOrderInput input) {
        log.debug("Request to save KitchenOrder: {}", input);
        var kitchenOrder = kitchenOrderMapper.update(new KitchenOrder(), input);
        kitchenOrder = kitchenOrderRepository.save(kitchenOrder);
        return kitchenOrder;
    }

    public KitchenOrder updateKitchenOrderStatus(String id, KitchenOrderStatusInput input) {
        log.debug("Request updateKitchenOrderStatus: {}", id);
        var kitchenOrder = kitchenOrderRepository.findById(id).orElseThrow();
        kitchenOrder = kitchenOrderMapper.update(kitchenOrder, input);
        // TODO: implement this method
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
