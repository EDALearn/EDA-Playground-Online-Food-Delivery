package io.zenwave360.example.restaurants.core.implementation.mappers;

import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = { BaseMapper.class })
public interface RestaurantBackOfficeServiceMapper {

    RestaurantBackOfficeServiceMapper INSTANCE = Mappers.getMapper(RestaurantBackOfficeServiceMapper.class);

    @Mapping(target = "id", ignore = true)
    Restaurant update(@MappingTarget Restaurant entity, Restaurant input);
    // Restaurant asRestaurant(String restaurantId);

    @Mapping(target = "id", ignore = true)
    Restaurant update(@MappingTarget Restaurant entity, String restaurantId);
    // Restaurant asRestaurant(MenuItem input);

    @Mapping(target = "id", ignore = true)
    Restaurant update(@MappingTarget Restaurant entity, MenuItem input);

    MenuItem asMenuItem(Restaurant entity);

    List<MenuItem> asMenuItemList(List<Restaurant> entity);

    default Page<MenuItem> asMenuItemPage(Page<Restaurant> page) {
        return page.map(this::asMenuItem);
    }
    // MenuItem asMenuItem(Restaurant input);

    @Mapping(target = "id", ignore = true)
    MenuItem update(@MappingTarget MenuItem entity, Restaurant input);
    // MenuItem asMenuItem(String restaurantId);

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
