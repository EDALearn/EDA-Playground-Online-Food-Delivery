package io.zenwave360.example.delivery.core.implementation.mappers;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.domain.events.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface EventsMapper {

    EventsMapper INSTANCE = Mappers.getMapper(EventsMapper.class);

    io.zenwave360.example.delivery.core.outbound.events.dtos.DeliveryStatusUpdated asDeliveryStatusUpdated(
            OrderStatusUpdated input);

    io.zenwave360.example.delivery.core.outbound.events.dtos.DeliveryStatusUpdated asDeliveryStatusUpdated(String id,
            DeliveryStatusInput input);

    io.zenwave360.example.delivery.core.outbound.events.dtos.DeliveryStatusUpdated asDeliveryStatusUpdated(
            DeliveryStatusUpdated event);

}
