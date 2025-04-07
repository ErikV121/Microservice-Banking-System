package com.ErikV121.account_service.dto.customerDto;

import com.ErikV121.account_service.dto.accountDto.AccountResponseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CustomerRequestDto(
        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Mobile number cannot be blank")
        @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Mobile number must be in format XXX-XXX-XXXX")
        String mobileNumber,

        String ssn,

        AccountResponseDto accountResponseDto
) {}
