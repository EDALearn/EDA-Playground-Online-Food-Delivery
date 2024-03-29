package io.zenwave360.example.customers.core.implementation.mappers;

import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface EventsMapper {

    EventsMapper INSTANCE = Mappers.getMapper(EventsMapper.class);

    io.zenwave360.example.customers.core.outbound.events.dtos.Address asAddress(Address address);

    io.zenwave360.example.customers.core.outbound.events.dtos.CustomerEvent asCustomerEvent(Customer customer);

    io.zenwave360.example.customers.core.outbound.events.dtos.Customer asCustomer(Customer customer);

    io.zenwave360.example.customers.core.outbound.events.dtos.CustomerEvent asCustomerEvent(String id);

    io.zenwave360.example.customers.core.outbound.events.dtos.CustomerAddressUpdated asCustomerAddressUpdated(
            Customer customer);

}
