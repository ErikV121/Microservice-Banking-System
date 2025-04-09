package com.ErikV121.card_service.dto.cardDto;

import com.ErikV121.card_service.entity.enums.CardType;

public record CreateCardRequestDto(
        CardType cardType,
        String mobileNumber,
        String emailId
) {
}
