package com.ErikV121.account_service.dto.accountDto;

import com.ErikV121.account_service.entity.enums.AccountType;

import java.util.UUID;

public record AccountResponseDto(
        Long accountNumber,
        UUID customerId,
        AccountType accountType,
        String branchAddress,
        String mobileNumber
) {}
