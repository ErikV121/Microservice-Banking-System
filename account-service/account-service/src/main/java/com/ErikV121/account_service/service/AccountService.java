package com.ErikV121.account_service.service;

import com.ErikV121.account_service.dto.accountDto.AccountRequestDto;
import com.ErikV121.account_service.dto.accountDto.AccountResponseDto;
import com.ErikV121.account_service.entity.Account;
import com.ErikV121.account_service.entity.Customer;
import com.ErikV121.account_service.exception.AccountTypeAlreadyExistsException;
import com.ErikV121.account_service.exception.ResourceNotFoundException;
import com.ErikV121.account_service.mapper.AccountMapper;
import com.ErikV121.account_service.repository.AccountRepository;
import com.ErikV121.account_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.accountMapper = accountMapper;
    }
    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto, String ssn) {
        Customer customer = customerRepository.findBySsn(ssn)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "SSN", ssn));

        Optional<Account> existingAccount = accountRepository.findAccountBySsnAndAccountType(ssn, accountRequestDto.accountType());
        if (existingAccount.isPresent()) {
            throw new AccountTypeAlreadyExistsException("Account type " + accountRequestDto.accountType() + " already exists for this customer");
        }

        Account newAccount = createNewAccount(accountRequestDto, customer);
        return accountMapper.toAccountResponseDto(accountRepository.save(newAccount));
    }

    public AccountResponseDto getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return accountMapper.toAccountResponseDto(account);
    }

// TODO revise this method
//  Add pagination and sorting
    public List<AccountResponseDto> getAllAccountsByCustomerSsn(String ssn) {
        if (!customerRepository.existsBySsn(ssn)) {
            throw new ResourceNotFoundException("Customer", "SSN", ssn);
        }

        List<Account> accounts = accountRepository.findAllAccountsByCustomerSsn(ssn);

        return accounts.stream()
                .map(accountMapper::toAccountResponseDto)
                .collect(Collectors.toList());
    }

    public AccountResponseDto updateAccount(Long accountId, AccountRequestDto accountRequestDto) {
        Account existingAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "AccountID", accountId.toString()));

        existingAccount.setAccountType(accountRequestDto.accountType());
        existingAccount.setBranchAddress(accountRequestDto.branchAddress());
        existingAccount.setMobileNumber(accountRequestDto.mobileNumber());

        Account updatedAccount = accountRepository.save(existingAccount);
        return accountMapper.toAccountResponseDto(updatedAccount);
    }

    public void deleteAccountByNumber(Long accountNumber) {
        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "AccountID", accountNumber.toString()));
        accountRepository.delete(account);
    }


    private Account createNewAccount(AccountRequestDto accountRequestDto, Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomer(customer);
        long randomNumber = 100000000L + new Random().nextInt(9000000);

        newAccount.setAccountId(randomNumber);
        newAccount.setAccountType(accountRequestDto.accountType());
        newAccount.setBranchAddress(accountRequestDto.branchAddress());
        newAccount.setMobileNumber(accountRequestDto.mobileNumber());

        return newAccount;
    }
}
