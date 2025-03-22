package com.ErikV121.account_service.mapper;

import com.ErikV121.account_service.dto.customerDto.CustomerRequestDto;
import com.ErikV121.account_service.dto.customerDto.CustomerResponseDto;
import com.ErikV121.account_service.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
     CustomerResponseDto toCustomerResponseDto(Customer customer);

     Customer toCustomer(CustomerRequestDto customerRequestDto);
}
