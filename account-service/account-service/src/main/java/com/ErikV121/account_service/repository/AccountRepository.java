package com.ErikV121.account_service.repository;

import com.ErikV121.account_service.entity.Account;
import com.ErikV121.account_service.entity.enums.AccountType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountType(AccountType accountType);

    @Query("SELECT a FROM Account a WHERE a.customer.customerId = " +
            "(SELECT c.customerId FROM Customer c WHERE c.ssn = :ssn)")
    List<Account> findAllAccountsByCustomerSsn(@Param("ssn") String ssm);

    @Query("SELECT a FROM Account a JOIN a.customer c WHERE c.ssn = :ssn AND a.accountType = :accountType")
    Optional<Account> findAccountBySsnAndAccountType(@Param("ssn") String ssn, @Param("accountType") AccountType accountType);
}
