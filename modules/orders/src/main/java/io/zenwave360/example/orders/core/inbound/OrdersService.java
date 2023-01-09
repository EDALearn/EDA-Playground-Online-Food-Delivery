package io.zenwave360.example.orders.core.inbound;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import java.util.List;
import java.util.Optional;

/** Inbound Service Port for managing [CustomerOrder]. */
public interface OrdersService {

    /**
     * Get the "id" customerOrder.
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<CustomerOrder> getCustomerOrder(String id);

    /** */
    public CustomerOrder createOrder(CustomerOrderInput input);

    /** */
    public CustomerOrder updateOrder(String id, CustomerOrderInput input);

    /** */
    public CustomerOrder updateKitchenStatus(String id, KitchenStatusInput input);

    /** */
    public CustomerOrder updateDeliveryStatus(String id, DeliveryStatusInput input);

    /** */
    public CustomerOrder cancelOrder(String id, CancelOrderInput input);

    /** */
    public List<CustomerOrder> searchOrders(OrdersFilter input);

}
