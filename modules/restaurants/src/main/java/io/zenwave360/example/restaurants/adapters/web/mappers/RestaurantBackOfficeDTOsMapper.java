package io.zenwave360.example.restaurants.adapters.web.mappers;

import io.zenwave360.example.restaurants.adapters.web.model.*;
import io.zenwave360.example.restaurants.core.domain.*;
import io.zenwave360.example.restaurants.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = BaseMapper.class)
public interface RestaurantBackOfficeDTOsMapper {

  RestaurantBackOfficeDTOsMapper INSTANCE = Mappers.getMapper(RestaurantBackOfficeDTOsMapper.class);

  // request mappings

  MenuItem asMenuItem(MenuItemDTO dto);

  // response mappings
  RestaurantDTO asRestaurantDTO(Restaurant entity);


  MenuItemDTO asMenuItemDTO(MenuItem entity);

  RestaurantPaginatedDTO asRestaurantPaginatedDTO(Page<Restaurant> entity);

  // response paginated mappings
  List<RestaurantDTO> asRestaurantDTOList(List<Restaurant> entityList);

  default Page<RestaurantDTO> asRestaurantDTOPage(Page<Restaurant> page) {
    return page.map(this::asRestaurantDTO);
  }

  List<MenuItemDTO> asMenuItemListDTOList(List<MenuItem> entityList);

  default Page<MenuItemDTO> asMenuItemListDTOPage(Page<MenuItem> page) {
    return page.map(this::asMenuItemDTO);
  }

  Restaurant asRestaurant(RestaurantDTO reqBody);
}
