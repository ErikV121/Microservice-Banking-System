package com.ErikV121.account_service.controller;

import com.ErikV121.account_service.constants.HttpConstants;
import com.ErikV121.account_service.dto.ResponseDto;
import com.ErikV121.account_service.dto.ResponseUtil;
import com.ErikV121.account_service.dto.customerDto.CustomerRequestDto;
import com.ErikV121.account_service.dto.customerDto.CustomerResponseDto;
import com.ErikV121.account_service.dto.customerDto.NewCustomerRequestDto;
import com.ErikV121.account_service.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public ResponseEntity<ResponseDto<Void>> createCustomer(@Valid @RequestBody NewCustomerRequestDto newCustomerRequestDto) {
        customerService.createCustomer(newCustomerRequestDto);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_CREATED, null, null));
    }

    @GetMapping("/{ssn}")
    public ResponseEntity<ResponseDto<CustomerResponseDto>> getCustomerBySsn(@PathVariable(value = "ssn") String ssn) {
        CustomerResponseDto customerResponseDto = customerService.getCustomerBySsn(ssn);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_OK, customerResponseDto, null));
    }

    @GetMapping("/{ssn}/accounts")
    public ResponseEntity<ResponseDto<CustomerResponseDto>> getCustomerBySsnAndAccounts(@PathVariable(value = "ssn") String ssn, @RequestParam(value = "includeAccounts", defaultValue = "false") boolean includeAccounts) {
        CustomerResponseDto customerResponseDto = customerService.getCustomerBySsnAndAccounts(ssn, includeAccounts);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_OK, customerResponseDto, null));
    }


    @PutMapping("/{ssn}")
    public ResponseEntity<ResponseDto<CustomerResponseDto>> updateCustomer(@Valid @PathVariable(value = "ssn") String ssn, @RequestBody CustomerRequestDto customerRequestDto) {
        CustomerResponseDto customerResponseDto = customerService.updateCustomer(ssn, customerRequestDto);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_OK, customerResponseDto, null));
    }

    @DeleteMapping("/{ssn}")
    public ResponseEntity<ResponseDto<Void>> deleteCustomer(@PathVariable(value = "ssn") String ssn) {
        customerService.deleteCustomerBySsn(ssn);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_OK, null, null));
    }

}
