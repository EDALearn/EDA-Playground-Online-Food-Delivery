package io.zenwave360.example.delivery.core.implementation.mappers;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface EventsMapper {

    EventsMapper INSTANCE = Mappers.getMapper(EventsMapper.class);

    io.zenwave360.example.delivery.core.domain.events.DeliveryOrderStatus asDeliveryOrderStatus(
            DeliveryOrderStatus deliveryOrderStatus);

    io.zenwave360.example.delivery.core.domain.events.DeliveryStatusUpdated asDeliveryStatusUpdated(Delivery delivery);

}
