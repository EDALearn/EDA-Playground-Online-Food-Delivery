package io.zenwave360.example.restaurants.core.implementation.mappers;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface MenuItemMapper {

    MenuItemMapper INSTANCE = Mappers.getMapper(MenuItemMapper.class);

    MenuItem asEntity(String restaurantId);

    @Mapping(target = "id", ignore = true)
    MenuItem update(@MappingTarget MenuItem entity, String restaurantId);

    @Mapping(target = "id", ignore = true)
    MenuItem update(@MappingTarget MenuItem entity, MenuItem input);

    Restaurant asRestaurant(MenuItem entity);

    List<Restaurant> asRestaurantList(List<MenuItem> entity);

    default Page<Restaurant> asRestaurantPage(Page<MenuItem> page) {
        return page.map(this::asRestaurant);
    }

}
