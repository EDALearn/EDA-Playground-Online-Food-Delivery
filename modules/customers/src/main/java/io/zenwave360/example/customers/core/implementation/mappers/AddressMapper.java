package io.zenwave360.example.customers.core.implementation.mappers;

import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

}
