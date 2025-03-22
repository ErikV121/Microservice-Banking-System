package com.ErikV121.account_service.entity;

import com.ErikV121.account_service.entity.enums.AccountType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Account extends BaseEntity {
    @Id
    @Column(name = "account_number")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long accountNumber;

    @Column(name = "customer_id")
    private UUID customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "mobile_number")
    private String mobileNumber;

    public Account() {}



    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
