package com.ErikV121.account_service.service;

import com.ErikV121.account_service.dto.accountDto.AccountRequestDto;
import com.ErikV121.account_service.dto.accountDto.AccountResponseDto;
import com.ErikV121.account_service.mapper.AccountMapper;
import com.ErikV121.account_service.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto) {
        return null;
    }

    public AccountResponseDto getAccountByNumber(Long accountNumber) {
        return null;
    }

    public List<AccountResponseDto> getAllAccountsByCustomerSsn(String ssn) {
        return null;
    }

    public AccountResponseDto updateAccount(Long accountNumber, AccountRequestDto accountRequestDto) {
        return null;
    }

    public void deleteAccountByNumber(Long accountNumber) {
    }
}
