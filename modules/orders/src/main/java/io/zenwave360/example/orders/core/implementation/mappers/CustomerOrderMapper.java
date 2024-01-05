package io.zenwave360.example.orders.core.implementation.mappers;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
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
    CustomerOrder update(@MappingTarget CustomerOrder entity, CustomerOrder input);

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
