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
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    @Mapping(target = "id", ignore = true)
    Restaurant update(@MappingTarget Restaurant entity, Restaurant input);

    Restaurant asEntity(String restaurantId);

    @Mapping(target = "id", ignore = true)
    Restaurant update(@MappingTarget Restaurant entity, String restaurantId);

    Restaurant asEntity(MenuItem input);

    @Mapping(target = "id", ignore = true)
    Restaurant update(@MappingTarget Restaurant entity, MenuItem input);

    MenuItem asMenuItem(Restaurant entity);

    List<MenuItem> asMenuItemList(List<Restaurant> entity);

    default Page<MenuItem> asMenuItemPage(Page<Restaurant> page) {
        return page.map(this::asMenuItem);
    }

}
