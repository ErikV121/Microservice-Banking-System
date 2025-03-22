package com.ErikV121.account_service.dto.customerDto;

import java.util.UUID;

public record CustomerResponseDto(
        String name,
        String email,
        String mobileNumber
) {}
