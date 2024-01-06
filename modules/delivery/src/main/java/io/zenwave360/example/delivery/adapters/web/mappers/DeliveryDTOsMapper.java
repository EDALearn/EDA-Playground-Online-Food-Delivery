package io.zenwave360.example.delivery.adapters.web.mappers;

import io.zenwave360.example.delivery.adapters.web.model.*;
import io.zenwave360.example.delivery.core.domain.*;
import io.zenwave360.example.delivery.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = BaseMapper.class)
public interface DeliveryDTOsMapper {

  DeliveryDTOsMapper INSTANCE = Mappers.getMapper(DeliveryDTOsMapper.class);

  // request mappings
  DeliveryStatusInput asDeliveryStatusInput(DeliveryStatusInputDTO dto);

  // response mappings
  DeliveryPaginatedDTO asDeliveryPaginatedDTO(Page<Delivery> entity);

  DeliveryDTO asDeliveryDTO(Delivery entity);

  // response paginated mappings
  List<DeliveryDTO> asDeliveryDTOList(List<Delivery> entityList);

  default Page<DeliveryDTO> asDeliveryDTOPage(Page<Delivery> page) {
    return page.map(this::asDeliveryDTO);
  }
}
