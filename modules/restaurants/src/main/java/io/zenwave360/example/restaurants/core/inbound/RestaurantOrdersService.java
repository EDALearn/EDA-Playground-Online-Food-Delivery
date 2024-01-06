package io.zenwave360.example.restaurants.core.inbound;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [KitchenOrder]. */
public interface RestaurantOrdersService {

    /**
     * Creates a kitchenOrder.
     * @param kitchenOrder the entity to save.
     * @return the persisted entity.
     */
    public KitchenOrder createKitchenOrder(KitchenOrderInput input);

    /** */
    public KitchenOrder onOrderStatusUpdated(String id, OrderStatusUpdated input);

    /** */
    public KitchenOrder updateKitchenOrderStatus(String id, KitchenOrderStatusInput input);

    /**
     * Get all the KitchenOrders matching the search criteria.
     * @param criteria the criteria with pagination information.
     * @return the list of entities.
     */
    public Page<KitchenOrder> searchKitchenOrders(KitchenOrdersFilter input, Pageable pageable);

}
