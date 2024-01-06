package io.zenwave360.example.delivery.core.implementation.mappers;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {

    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    Delivery asEntity(DeliveryStatusInput input);

    @Mapping(target = "id", ignore = true)
    Delivery update(@MappingTarget Delivery entity, DeliveryStatusInput input);

    Delivery asEntity(DeliveryInput input);

    @Mapping(target = "id", ignore = true)
    Delivery update(@MappingTarget Delivery entity, DeliveryInput input);

}
