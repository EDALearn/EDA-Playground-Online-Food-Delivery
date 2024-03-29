package io.zenwave360.example.delivery.core.domain;

import io.zenwave360.example.delivery.core.domain.events.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public class DeliveryAggregate {

    private static final Mapper mapper = Mappers.getMapper(Mapper.class);

    private final Delivery rootEntity;

    private final List<Object> events = new ArrayList<>();

    public DeliveryAggregate() {
        this(new Delivery());
    }

    public DeliveryAggregate(Delivery rootEntity) {
        this.rootEntity = rootEntity;
    }

    public String getId() {
        return rootEntity.getId();
    }

    public Delivery getRootEntity() {
        return rootEntity;
    }

    public List<?> getEvents() {
        return Collections.unmodifiableList(events);
    }

    /** set Events: [DeliveryStatusUpdated]. */
    public void createDelivery(DeliveryInput input) {
        mapper.update(rootEntity, input);
        var delivery = mapper.update(rootEntity, input);
        rootEntity.setId(UUID.randomUUID().toString()); // XXX: User Assigned ID necessary for sending events
        var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                .setDeliveryId(delivery.getId())
                .setCustomerOrderId(input.getOrderId())
                .setStatus(DeliveryOrderStatus.ACCEPTED);
        // sleep 1 second to avoid race conditions on orders (TB FIXED)
        sleep(1000);
        events.add(deliveryUpdateStatus);
    }

    /** set Events: [DeliveryStatusUpdated]. */
    public void onOrderStatusUpdated(OrderStatusUpdated input) {
        if ("CANCELLED".equals(input.getStatus())) {
            rootEntity.setStatus(io.zenwave360.example.delivery.core.domain.DeliveryOrderStatus.CANCELLED);
            var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                    .setDeliveryId(rootEntity.getId())
                    .setCustomerOrderId(input.getOrderId())
                    .setStatus(DeliveryOrderStatus.CANCELLED);
            events.add(deliveryUpdateStatus);
        }
        if ("KITCHEN_READY".equals(input.getStatus())) {
            rootEntity.setStatus(io.zenwave360.example.delivery.core.domain.DeliveryOrderStatus.IN_PROGRESS);
            var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                    .setDeliveryId(rootEntity.getId())
                    .setCustomerOrderId(input.getOrderId())
                    .setStatus(DeliveryOrderStatus.IN_PROGRESS);
            events.add(deliveryUpdateStatus);
        }
    }

    /** set Events: [DeliveryStatusUpdated]. */
    public void updateDeliveryStatus(DeliveryStatusInput input) {
        // TODO: implement this command
        mapper.update(rootEntity, input);
        events.add(mapper.asDeliveryStatusUpdated(rootEntity));

        mapper.update(rootEntity, input);
        var deliveryUpdateStatus = new DeliveryStatusUpdated() //
                .setDeliveryId(rootEntity.getId())
                .setCustomerOrderId(rootEntity.getOrderId())
                .setStatus(rootEntity.getStatus());
        events.add(deliveryUpdateStatus);
    }

    @org.mapstruct.Mapper
    interface Mapper {

        Delivery update(@MappingTarget Delivery entity, OrderStatusUpdated input);

        Delivery update(@MappingTarget Delivery entity, DeliveryStatusInput input);

        Delivery update(@MappingTarget Delivery entity, DeliveryInput input);

        DeliveryStatusUpdated asDeliveryStatusUpdated(Delivery entity);

    }

    void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
