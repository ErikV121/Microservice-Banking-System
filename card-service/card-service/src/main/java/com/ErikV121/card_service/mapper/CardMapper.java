package com.ErikV121.card_service.mapper;

import com.ErikV121.card_service.dto.cardDto.CardRequestDto;
import com.ErikV121.card_service.dto.cardDto.CardResponseDto;
import com.ErikV121.card_service.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardResponseDto toCardResponseDto(Card card);

    Card toCard(CardRequestDto cardRequestDto);
}
