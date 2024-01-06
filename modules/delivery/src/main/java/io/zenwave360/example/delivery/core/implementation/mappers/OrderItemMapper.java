package io.zenwave360.example.delivery.core.implementation.mappers;

import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemMapper {

    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

}
