package io.zenwave360.example.orders.core.implementation.mappers;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

}
