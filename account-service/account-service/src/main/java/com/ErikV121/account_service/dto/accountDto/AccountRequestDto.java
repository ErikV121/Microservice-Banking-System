package com.ErikV121.account_service.dto.accountDto;

import com.ErikV121.account_service.entity.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AccountRequestDto(
        @NotNull(message = "Account type cannot be null")
        AccountType accountType,

        @NotBlank(message = "Branch address cannot be blank")
        String branchAddress,

        @NotBlank(message = "Mobile number cannot be blank")
        @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$",
                message = "Mobile number must be in format XXX-XXX-XXXX")
        String mobileNumber
) {}
