package io.zenwave360.example.orders.core.implementation.mappers;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.domain.events.OrderEvent;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

}
