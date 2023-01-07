package io.zenwave360.example.delivery.core.inbound;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [Delivery]. */
public interface DeliveryService {

    /**
     * Creates a delivery.
     * @param delivery the entity to save.
     * @return the persisted entity.
     */
    public Delivery createDelivery(DeliveryInput input);

    /**
     *
     */
    public void onOrderStatusUpdated(OrderStatusUpdated input);

    /** */
    public Delivery updateDeliveryStatus(String id, DeliveryStatusInput input);

    /**
     * Get all the Deliveries.
     * @param criteria the criteria with pagination information.
     * @return the list of entities.
     */
    public Page<Delivery> listDeliveries(Pageable pageable);

}
