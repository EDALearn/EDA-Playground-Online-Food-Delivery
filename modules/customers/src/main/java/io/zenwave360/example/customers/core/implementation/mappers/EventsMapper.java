package io.zenwave360.example.customers.core.implementation.mappers;

import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface EventsMapper {

    EventsMapper INSTANCE = Mappers.getMapper(EventsMapper.class);

    io.zenwave360.example.customers.core.domain.events.Address asAddress(Address address);

    io.zenwave360.example.customers.core.domain.events.CustomerEvent asCustomerEvent(Customer customer);

    io.zenwave360.example.customers.core.domain.events.Customer asCustomer(Customer customer);

    io.zenwave360.example.customers.core.domain.events.CustomerEvent asCustomerEvent(String id);

    io.zenwave360.example.customers.core.domain.events.CustomerAddressUpdated asCustomerAddressUpdated(
            Customer customer);

}
