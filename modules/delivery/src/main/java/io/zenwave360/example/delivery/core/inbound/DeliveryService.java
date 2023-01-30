package io.zenwave360.example.delivery.core.inbound;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [Delivery]. */
public interface DeliveryService {

    /** With Events: [DeliveryStatusUpdated]. */
    public Delivery createDelivery(DeliveryInput input);

    /** With Events: [DeliveryStatusUpdated]. */
    public Delivery onOrderStatusUpdated(String id, OrderStatusUpdated input);

    /** With Events: [DeliveryStatusUpdated]. */
    public Delivery updateDeliveryStatus(String id, DeliveryStatusInput input);

    /** */
    public Page<Delivery> listDeliveries(Pageable pageable);

}
