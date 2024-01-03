package io.zenwave360.example.customers.adapters.web.mappers;

import io.zenwave360.example.customers.adapters.web.model.*;
import io.zenwave360.example.customers.core.domain.*;
import io.zenwave360.example.customers.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = BaseMapper.class)
public interface CustomerDTOsMapper {

  CustomerDTOsMapper INSTANCE = Mappers.getMapper(CustomerDTOsMapper.class);

  // request mappings
  Address asAddress(AddressDTO dto);

  Customer asCustomer(CustomerDTO dto);

  // response mappings
  CustomerDTO asCustomerDTO(Customer entity);

  CustomerPaginatedDTO asCustomerPaginatedDTO(Page<Customer> entity);

  // response paginated mappings
  List<CustomerDTO> asCustomerDTOList(List<Customer> entityList);

  default Page<CustomerDTO> asCustomerDTOPage(Page<Customer> page) {
    return page.map(this::asCustomerDTO);
  }
}
