package io.zenwave360.example.orders.core.inbound;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import java.math.*;
import java.time.*;
import java.util.*;

/** Inbound Service Port for managing [CustomerOrder]. */
public interface OrdersService {

    /** */
    public Optional<CustomerOrder> getCustomerOrder(String id);

    /** With Events: [OrderEvent]. */
    public CustomerOrder createOrder(CustomerOrderInput input);

    /** With Events: [OrderEvent, OrderStatusUpdated]. */
    public CustomerOrder updateOrder(String id, CustomerOrderInput input);

    /** With Events: [OrderEvent, OrderStatusUpdated]. */
    public CustomerOrder updateKitchenStatus(String id, KitchenStatusInput input);

    /** With Events: [OrderEvent, OrderStatusUpdated]. */
    public CustomerOrder updateDeliveryStatus(String id, DeliveryStatusInput input);

    /** With Events: [OrderEvent, OrderStatusUpdated]. */
    public CustomerOrder cancelOrder(String id, CancelOrderInput input);

    /** */
    public List<CustomerOrder> searchOrders(OrdersFilter input);

}
