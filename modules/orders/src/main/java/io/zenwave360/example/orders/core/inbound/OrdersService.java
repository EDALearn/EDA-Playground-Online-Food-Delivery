package io.zenwave360.example.orders.core.inbound;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import java.util.List;

/** Inbound Service Port for managing [CustomerOrder]. */
public interface OrdersService {

    /** */
    public CustomerOrder getOrder(String id);

    /** */
    public CustomerOrder createOrder(CustomerOrder input);

    /** */
    public CustomerOrder updateOrder(String id, CustomerOrder input);

    /** */
    public CustomerOrder updateKitchenStatus(String id, KitchenStatusInput input);

    /** */
    public CustomerOrder updateDeliveryStatus(String id, DeliveryStatusInput input);

    /** */
    public CustomerOrder cancelOrder(String id, CancelOrderInput input);

    /** */
    public List<CustomerOrder> searchOrders(OrdersFilter input);

}
