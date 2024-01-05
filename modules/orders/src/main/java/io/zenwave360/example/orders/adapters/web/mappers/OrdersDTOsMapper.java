package io.zenwave360.example.orders.adapters.web.mappers;

import io.zenwave360.example.orders.adapters.web.model.*;
import io.zenwave360.example.orders.core.domain.*;
import io.zenwave360.example.orders.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = BaseMapper.class)
public interface OrdersDTOsMapper {

  OrdersDTOsMapper INSTANCE = Mappers.getMapper(OrdersDTOsMapper.class);

  // request mappings
  OrdersFilter asOrdersFilter(OrdersFilterDTO dto);

  CustomerOrder asCustomerOrder(CustomerOrderDTO dto);

  CancelOrderInput asCancelOrderInput(CancelOrderInputDTO dto);

  // response mappings
  CustomerOrderDTO asCustomerOrderDTO(CustomerOrder entity);

  List<CustomerOrderDTO> asCustomerOrderListDTO(List<CustomerOrder> entity);

}
