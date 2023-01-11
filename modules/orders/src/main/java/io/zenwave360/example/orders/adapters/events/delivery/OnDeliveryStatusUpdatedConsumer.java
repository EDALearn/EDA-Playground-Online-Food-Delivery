package io.zenwave360.example.orders.adapters.events.delivery;


import io.zenwave360.example.orders.adapters.commands.IOnDeliveryStatusUpdatedConsumerService;
import io.zenwave360.example.orders.core.domain.DeliveryStatus;
import io.zenwave360.example.orders.core.domain.events.DeliveryStatusUpdated;
import io.zenwave360.example.orders.core.inbound.OrdersService;
import io.zenwave360.example.orders.core.inbound.dtos.DeliveryStatusInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OnDeliveryStatusUpdatedConsumer implements IOnDeliveryStatusUpdatedConsumerService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private OrdersService ordersService;

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    /** */
    public void onDeliveryStatusUpdated(DeliveryStatusUpdated payload,
                                        IOnDeliveryStatusUpdatedConsumerService.DeliveryStatusUpdatedHeaders headers) {
        log.debug("Received command request for onDeliveryStatusUpdated: {} with headers {}", payload, headers);
        DeliveryStatusInput input = new DeliveryStatusInput() //
            .setDeliveryOrderId(payload.getDeliveryId())
            .setDeliveryStatus(map(payload.getStatus()));
        ordersService.updateDeliveryStatus(payload.getCustomerOrderId(), input);
    };

    private DeliveryStatus map(io.zenwave360.example.orders.core.domain.events.DeliveryStatus status) {
        return DeliveryStatus.valueOf(status.name());
    }

}
