package io.zenwave360.example.restaurants.adapters.web.mappers;

import io.zenwave360.example.restaurants.adapters.web.model.*;
import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.math.*;
import java.time.*;
import java.util.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = BaseMapper.class)
public interface RestaurantBackOfficeDTOsMapper {

  RestaurantBackOfficeDTOsMapper INSTANCE = Mappers.getMapper(RestaurantBackOfficeDTOsMapper.class);

  // request mappings
  MenuItem asMenuItem(MenuItemDTO dto);

  Restaurant asRestaurant(RestaurantDTO dto);

  // response mappings

  MenuItemDTO asMenuItemDTO(MenuItem entity);

  RestaurantDTO asRestaurantDTO(Restaurant entity);

  List<MenuItemDTO> asMenuItemDTOList(List<MenuItem> entityList);

  List<RestaurantDTO> asRestaurantDTOList(List<Restaurant> entityList);

  RestaurantPaginatedDTO asRestaurantPaginatedDTO(Page<Restaurant> page);

  default Page<RestaurantDTO> asRestaurantDTOPage(Page<Restaurant> page) {
    return page.map(this::asRestaurantDTO);
  }
}
