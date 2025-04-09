package com.ErikV121.card_service.dto.cardDto;

import com.ErikV121.card_service.entity.enums.CardType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CardRequestDto(
        String cardHolderName,
        CardType cardType,
        LocalDate expiryDate,
        BigDecimal creditLimit,
        String mobileNumber
) {
}
