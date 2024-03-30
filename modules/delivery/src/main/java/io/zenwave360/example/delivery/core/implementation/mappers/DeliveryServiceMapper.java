package io.zenwave360.example.delivery.core.implementation.mappers;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface DeliveryServiceMapper {

    DeliveryServiceMapper INSTANCE = Mappers.getMapper(DeliveryServiceMapper.class);

    // Delivery asDelivery(OrderStatusUpdated input);

    @Mapping(target = "id", ignore = true)
    Delivery update(@MappingTarget Delivery entity, OrderStatusUpdated input);
    // Delivery asDelivery(DeliveryStatusInput input);

    @Mapping(target = "id", ignore = true)
    Delivery update(@MappingTarget Delivery entity, DeliveryStatusInput input);
    // Delivery asDelivery(DeliveryInput input);

    @Mapping(target = "id", ignore = true)
    Delivery update(@MappingTarget Delivery entity, DeliveryInput input);

}
