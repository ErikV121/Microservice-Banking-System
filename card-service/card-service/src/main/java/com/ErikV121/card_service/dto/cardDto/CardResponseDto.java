package com.ErikV121.card_service.dto.cardDto;

import com.ErikV121.card_service.entity.enums.CardType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CardResponseDto(
        UUID cardId,
        UUID customerId,
        String cardHolderName,
        String lastFourDigits,
        CardType cardType,
        BigDecimal creditLimit,
        String status,
        LocalDate issueDate,
        LocalDate expiryDate
) {
}