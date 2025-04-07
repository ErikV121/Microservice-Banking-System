package com.ErikV121.account_service.service;

import com.ErikV121.account_service.dto.customerDto.CustomerRequestDto;
import com.ErikV121.account_service.dto.customerDto.CustomerResponseDto;
import com.ErikV121.account_service.dto.customerDto.NewCustomerRequestDto;
import com.ErikV121.account_service.entity.Customer;
import com.ErikV121.account_service.exception.CustomerAlreadyExistException;
import com.ErikV121.account_service.exception.ResourceNotFoundException;
import com.ErikV121.account_service.mapper.AccountMapper;
import com.ErikV121.account_service.mapper.CustomerMapper;
import com.ErikV121.account_service.repository.AccountRepository;
import com.ErikV121.account_service.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, AccountRepository accountRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponseDto createCustomer(NewCustomerRequestDto newCustomerRequestDto) {
        log.info("Creating new customer with SSN {}", newCustomerRequestDto.ssn());
        if (customerRepository.findBySsn(newCustomerRequestDto.ssn()).isPresent()) {
            throw new CustomerAlreadyExistException("Customer with SSN already exists");
        }

        Customer newCustomer = customerRepository.save(customerMapper.toCustomer(newCustomerRequestDto));
        log.info("New customer created : {}", newCustomer);
        return customerMapper.toCustomerResponseDto(newCustomer);
    }

    public CustomerResponseDto getCustomerBySsn(String ssn) {
        Customer customer = customerRepository.findBySsn(ssn).orElseThrow(() -> new CustomerAlreadyExistException("Customer with SSN already exists"));
        return customerMapper.toCustomerResponseDto(customer);
    }

    public CustomerResponseDto getCustomerBySsnAndAccounts(String ssn, boolean includeAccounts) {
        Customer customer = customerRepository.findBySsn(ssn).orElseThrow(() -> new CustomerAlreadyExistException("Customer with SSN already exists"));
        if (includeAccounts) {
            customer.setAccounts(accountRepository.findAllAccountsByCustomerSsn(ssn));
        }
        return customerMapper.toCustomerResponseDto(customer);
    }

    public CustomerResponseDto updateCustomer(String ssn, CustomerRequestDto customerRequestDto) {
        Customer existingCustomer = customerRepository.findBySsn(ssn).orElseThrow(() -> new ResourceNotFoundException("Customer","SSN",ssn));

        existingCustomer.setName(customerRequestDto.name());
        existingCustomer.setEmail(customerRequestDto.email());
        existingCustomer.setMobileNumber(customerRequestDto.mobileNumber());
        existingCustomer.setSsn(customerRequestDto.ssn());

        Customer updatedCustomer = customerRepository.save(existingCustomer);
        log.info("Customer updated : {}", updatedCustomer);
        return customerMapper.toCustomerResponseDto(updatedCustomer);
    }

    public void deleteCustomerBySsn(String ssn) {
        Customer customer = customerRepository.findBySsn(ssn).orElseThrow(() -> new CustomerAlreadyExistException("Customer with SSN already exists"));
        customerRepository.delete(customer);
        log.info("Customer deleted : {}", customer);
    }
}
