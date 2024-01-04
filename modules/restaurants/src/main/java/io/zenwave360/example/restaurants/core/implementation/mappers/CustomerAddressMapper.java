package io.zenwave360.example.restaurants.core.implementation.mappers;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerAddressMapper {

    CustomerAddressMapper INSTANCE = Mappers.getMapper(CustomerAddressMapper.class);

}
