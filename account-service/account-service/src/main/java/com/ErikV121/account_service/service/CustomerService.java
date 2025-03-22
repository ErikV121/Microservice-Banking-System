package com.ErikV121.account_service.service;

import com.ErikV121.account_service.dto.customerDto.CustomerRequestDto;
import com.ErikV121.account_service.dto.customerDto.CustomerResponseDto;
import com.ErikV121.account_service.dto.customerDto.NewCustomerRequestDto;
import com.ErikV121.account_service.entity.Customer;
import com.ErikV121.account_service.exception.CustomerAlreadyExistException;
import com.ErikV121.account_service.mapper.CustomerMapper;
import com.ErikV121.account_service.repository.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponseDto createCustomer(NewCustomerRequestDto newCustomerRequestDto) {
//        Customer customer = customerRepository.findBySsn(newCustomerRequestDto.ssn()).orElseThrow(() -> new CustomerAlreadyExistException("Customer with SSN already exists"));
//
        return null;
    }

    public CustomerResponseDto getCustomerBySsn(String ssn) {
//        Customer customer = customerRepository.findBySsn(ssn).orElseThrow(() -> new CustomerAlreadyExistException("Customer with SSN already exists"));

        return null;
    }

    public CustomerResponseDto updateCustomer(CustomerRequestDto customerRequestDto) {

        return null;
    }

    public void deleteCustomerBySsn(String ssn) {

    }



}
