package io.zenwave360.example.orders.core.implementation.mappers;

import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BaseMapper.class })
public interface OrdersServiceMapper {

    OrdersServiceMapper INSTANCE = Mappers.getMapper(OrdersServiceMapper.class);

    // CustomerOrder asCustomerOrder(OrdersFilter input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, OrdersFilter input);
    // CustomerOrder asCustomerOrder(DeliveryStatusInput input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, DeliveryStatusInput input);
    // CustomerOrder asCustomerOrder(KitchenStatusInput input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, KitchenStatusInput input);
    // CustomerOrder asCustomerOrder(CustomerOrderInput input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, CustomerOrderInput input);
    // CustomerOrder asCustomerOrder(CancelOrderInput input);

    @Mapping(target = "id", ignore = true)
    CustomerOrder update(@MappingTarget CustomerOrder entity, CancelOrderInput input);

}
