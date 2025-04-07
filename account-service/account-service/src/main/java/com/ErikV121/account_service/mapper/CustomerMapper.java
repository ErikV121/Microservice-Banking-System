package com.ErikV121.account_service.mapper;

import com.ErikV121.account_service.dto.customerDto.CustomerRequestDto;
import com.ErikV121.account_service.dto.customerDto.CustomerResponseDto;
import com.ErikV121.account_service.dto.customerDto.NewCustomerRequestDto;
import com.ErikV121.account_service.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
     CustomerResponseDto toCustomerResponseDto(Customer customer);

     @Mapping(target = "ssn", source = "ssn")
     Customer toCustomer(NewCustomerRequestDto newCustomerRequestDto);

     @Mapping(target = "ssn", source = "ssn")
     Customer toCustomer(CustomerRequestDto customerRequestDto);
}
