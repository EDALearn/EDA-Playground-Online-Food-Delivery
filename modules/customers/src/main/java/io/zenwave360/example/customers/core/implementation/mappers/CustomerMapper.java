package io.zenwave360.example.customers.core.implementation.mappers;

import io.zenwave360.example.customers.core.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	@Mapping(target = "id", ignore = true)
	default Address updateCustomerAddress(@MappingTarget Customer entity, String identifier, Address input) {
		// update by address.identifier
		var currentAddress = entity.getAddresses().stream().filter(a -> Objects.equals(a.getIdentifier(), identifier)).findFirst();
		if (currentAddress.isPresent()) {
			var index = entity.getAddresses().indexOf(currentAddress.get());
			entity.getAddresses().set(index, input);
		} else {
			entity.addAddresses(input);
		}
		return currentAddress.orElse(null);
	}

	@Mapping(target = "id", ignore = true)
	Customer update(@MappingTarget Customer entity, Customer input);

}
