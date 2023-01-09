package io.zenwave360.example.orders.core.implementation.mappers;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import io.zenwave360.example.orders.customers.client.model.AddressDTO;
import io.zenwave360.example.orders.customers.client.model.CustomerDTO;
import io.zenwave360.example.orders.restaurants.client.model.RestaurantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerOrderMapper {

    CustomerOrderMapper INSTANCE = Mappers.getMapper(CustomerOrderMapper.class);

    CustomerOrder asEntity(OrdersFilter input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, OrdersFilter input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, CustomerOrderInput input);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "customerDetails", source = "customerDetails")
    @Mapping(target = "customerDetails.address", source = "address")
    CustomerOrder update(@MappingTarget CustomerOrder entity, CustomerOrderInput input, CustomerDTO customerDetails, AddressDTO address, RestaurantDTO restaurantDetails);

    @Mapping(target = "customerId", source = "id")
    Customer asCustomer(CustomerDTO customerDetails);

    Address asAddress(AddressDTO addressDetails);

    @Mapping(target = "restaurantId", source = "id")
    Restaurant asRestaurant(RestaurantDTO restaurantDetails);

    CustomerOrder asEntity(DeliveryStatusInput input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, DeliveryStatusInput input);

    CustomerOrder asEntity(KitchenStatusInput input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, KitchenStatusInput input);

    CustomerOrder asEntity(CancelOrderInput input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, CancelOrderInput input);

}
