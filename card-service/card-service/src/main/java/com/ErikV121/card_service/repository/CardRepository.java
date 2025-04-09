package com.ErikV121.card_service.repository;

import com.ErikV121.card_service.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
    Card findByCardId(UUID cardId);
    Card findByCardNumber(String cardNumber);
}
