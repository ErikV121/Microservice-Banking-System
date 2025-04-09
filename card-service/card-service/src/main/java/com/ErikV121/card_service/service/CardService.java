package com.ErikV121.card_service.service;

import com.ErikV121.card_service.dto.cardDto.CardRequestDto;
import com.ErikV121.card_service.dto.cardDto.CardResponseDto;
import com.ErikV121.card_service.entity.Card;
import com.ErikV121.card_service.mapper.CardMapper;
import com.ErikV121.card_service.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardService(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

//    TODO implement CRUD

    public CardResponseDto createCard(CardRequestDto cardRequestDto) {
        return null;
    }

    public CardResponseDto getCardById(Long cardId) {
        return null;
    }

    public List<Card> getAllCards() {
        return null;
    }

    public CardResponseDto updateCard(CardRequestDto cardRequestDto) {
        return null;
    }

    public void deleteCard(Long cardId) {

    }

}


