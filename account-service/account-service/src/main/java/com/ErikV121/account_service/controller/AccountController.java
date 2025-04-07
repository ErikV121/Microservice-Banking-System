package com.ErikV121.account_service.controller;

import com.ErikV121.account_service.constants.HttpConstants;
import com.ErikV121.account_service.dto.ResponseDto;
import com.ErikV121.account_service.dto.ResponseUtil;
import com.ErikV121.account_service.dto.accountDto.AccountRequestDto;
import com.ErikV121.account_service.dto.accountDto.AccountResponseDto;
import com.ErikV121.account_service.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{ssn}")
    public ResponseEntity<ResponseDto<AccountResponseDto>> createAccount(@PathVariable(value = "ssn") String ssn, @RequestBody AccountRequestDto accountRequestDto) {
        AccountResponseDto accountResponseDto = accountService.createAccount(accountRequestDto, ssn);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_CREATED, accountResponseDto, null));
    }

    @GetMapping("/{accountId}/account")
    public ResponseEntity<ResponseDto<AccountResponseDto>> getAccountById(@PathVariable(value = "accountId") Long accountId) {
        AccountResponseDto accountResponseDto = accountService.getAccountById(accountId);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_OK, accountResponseDto, null));
    }

    @GetMapping("/{ssn}")
    public ResponseEntity<ResponseDto<List<AccountResponseDto>>> getAllAccountsByCustomerSsn(@PathVariable(value = "ssn") String ssn) {
        List<AccountResponseDto> accountResponseDtos = accountService.getAllAccountsByCustomerSsn(ssn);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_OK, accountResponseDtos, null));
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<ResponseDto<AccountResponseDto>> updateAccount(@PathVariable(value = "accountId") Long accountId, @RequestBody AccountRequestDto accountRequestDto) {
        AccountResponseDto accountResponseDto = accountService.updateAccount(accountId, accountRequestDto);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_OK, accountResponseDto, null));
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<ResponseDto<Void>> deleteAccount(@PathVariable(value = "accountId") Long accountId) {
        accountService.deleteAccountByNumber(accountId);

        return ResponseEntity.ok(ResponseUtil.success(HttpConstants.MESSAGE_OK, null, null));
    }
}
