package io.zenwave360.example.customers.core.implementation.mappers;

import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper(uses = { BaseMapper.class })
public interface CustomerServiceMapper {

    CustomerServiceMapper INSTANCE = Mappers.getMapper(CustomerServiceMapper.class);

    @Mapping(target = "id", ignore = true)
    Customer update(@MappingTarget Customer entity, Customer input);

    @Mapping(target = "id", ignore = true)
    default Customer update(@MappingTarget Customer entity, String identifier, Address address)  {
        // update by address.identifier
        var currentAddress = entity.getAddresses().stream().filter(a -> Objects.equals(a.getIdentifier(), identifier)).findFirst();
        if (currentAddress.isPresent()) {
            var index = entity.getAddresses().indexOf(currentAddress.get());
            entity.getAddresses().set(index, address);
        } else {
            entity.addAddresses(address);
        }
        return entity;
    }

}
