package io.zenwave360.example.orders.adapters.commands;

import io.zenwave360.example.orders.adapters.commands.IDoCancelOrderConsumerService;

import io.zenwave360.example.orders.adapters.commands.IDoCancelOrderConsumerService;


import io.zenwave360.example.orders.core.outbound.events.dtos.CancelOrderInput;
import io.zenwave360.example.orders.core.inbound.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DoCancelOrderConsumerService implements IDoCancelOrderConsumerService {

    private OrdersService ordersService;

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Override
    public void doCancelOrder(CancelOrderInput payload, CancelOrderInputHeaders headers) {
        log.debug("Received CancelOrderInput: {}", payload);
        var input = new io.zenwave360.example.orders.core.inbound.dtos.CancelOrderInput() //
            .setId(payload.getId())
            .setReason(payload.getReason());
        ordersService.cancelOrder(payload.getId(), input);
    }

}
