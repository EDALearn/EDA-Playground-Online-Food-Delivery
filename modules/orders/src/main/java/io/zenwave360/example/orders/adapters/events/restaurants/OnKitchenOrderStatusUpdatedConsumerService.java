package io.zenwave360.example.orders.adapters.events.restaurants;


import io.zenwave360.example.orders.adapters.commands.IOnKitchenOrderStatusUpdatedConsumerService;
import io.zenwave360.example.orders.core.domain.KitchenStatus;
import io.zenwave360.example.orders.core.domain.events.KitchenOrderStatus;
import io.zenwave360.example.orders.core.domain.events.KitchenOrderStatusUpdated;
import io.zenwave360.example.orders.core.inbound.OrdersService;
import io.zenwave360.example.orders.core.inbound.dtos.KitchenStatusInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OnKitchenOrderStatusUpdatedConsumerService implements IOnKitchenOrderStatusUpdatedConsumerService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private OrdersService ordersService;

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    /** */
    public void onKitchenOrderStatusUpdated(KitchenOrderStatusUpdated payload,
                                            KitchenOrderStatusUpdatedHeaders headers) {
        log.debug("Received command request for onKitchenOrderStatusUpdated: {} with headers {}", payload, headers);
        KitchenStatusInput input = new KitchenStatusInput() //
                .setKitchenOrderId(payload.getKitchenOrderId())
                .setKitchenStatus(map(payload.getStatus()));
        ordersService.updateKitchenStatus(payload.getCustomerOrderId(), input);
    };

    private KitchenStatus map(KitchenOrderStatus status) {
        return KitchenStatus.valueOf(status.name());
    }
}
