package io.zenwave360.example.delivery.core.domain;

import io.zenwave360.example.delivery.core.domain.events.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    /** With Events: [DeliveryStatusUpdated]. */
    public void createDelivery(DeliveryInput input) {
        // TODO: implement this command
        mapper.update(rootEntity, input);
        events.add(mapper.asDeliveryStatusUpdated(rootEntity));
    }

    /** With Events: [DeliveryStatusUpdated]. */
    public void onOrderStatusUpdated(OrderStatusUpdated input) {
        // TODO: implement this command
        mapper.update(rootEntity, input);
        events.add(mapper.asDeliveryStatusUpdated(rootEntity));
    }

    /** With Events: [DeliveryStatusUpdated]. */
    public void updateDeliveryStatus(DeliveryStatusInput input) {
        // TODO: implement this command
        mapper.update(rootEntity, input);
        events.add(mapper.asDeliveryStatusUpdated(rootEntity));
    }

    @org.mapstruct.Mapper
    interface Mapper {

        Delivery update(@MappingTarget Delivery entity, OrderStatusUpdated input);

        Delivery update(@MappingTarget Delivery entity, DeliveryStatusInput input);

        Delivery update(@MappingTarget Delivery entity, DeliveryInput input);

        DeliveryStatusUpdated asDeliveryStatusUpdated(Delivery entity);

    }

}
