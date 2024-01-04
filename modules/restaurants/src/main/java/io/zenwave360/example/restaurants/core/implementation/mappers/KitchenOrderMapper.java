package io.zenwave360.example.restaurants.core.implementation.mappers;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KitchenOrderMapper {

    KitchenOrderMapper INSTANCE = Mappers.getMapper(KitchenOrderMapper.class);

    KitchenOrder asEntity(KitchenOrderStatusInput input);

    @Mapping(target = "id", ignore = true)
    KitchenOrder update(@MappingTarget KitchenOrder entity, KitchenOrderStatusInput input);

    KitchenOrder asEntity(KitchenOrderInput input);

    @Mapping(target = "id", ignore = true)
    KitchenOrder update(@MappingTarget KitchenOrder entity, KitchenOrderInput input);

    KitchenOrder asEntity(KitchenOrdersFilter input);

    @Mapping(target = "id", ignore = true)
    KitchenOrder update(@MappingTarget KitchenOrder entity, KitchenOrdersFilter input);

}
