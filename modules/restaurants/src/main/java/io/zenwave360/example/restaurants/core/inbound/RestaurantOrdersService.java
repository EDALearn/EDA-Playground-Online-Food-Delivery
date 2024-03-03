package io.zenwave360.example.restaurants.core.inbound;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.math.*;
import java.time.*;
import java.util.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [KitchenOrder]. */
public interface RestaurantOrdersService {

    /** With Events: [KitchenOrderStatusUpdated]. */
    public KitchenOrder createKitchenOrder(KitchenOrderInput input);

    /** With Events: [KitchenOrderStatusUpdated]. */
    public void onOrderStatusUpdated(OrderStatusUpdated input);

    /** With Events: [KitchenOrderStatusUpdated]. */
    public KitchenOrder updateKitchenOrderStatus(String id, KitchenOrderStatusInput input);

    /** */
    public Page<KitchenOrder> searchKitchenOrders(KitchenOrdersFilter input, Pageable pageable);

}
