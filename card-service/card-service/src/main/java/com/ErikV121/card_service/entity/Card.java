package com.ErikV121.card_service.entity;

import com.ErikV121.card_service.entity.enums.CardType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
public class Card extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "card_id", updatable = false)
    private UUID cardId;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "card_number", unique = true)
    private String cardNumber;

    @Column(name = "last_four_digits")
    private String lastFourDigits;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    @Column(name = "balance")
    private int balance;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @Column(name = "status")
    private String status;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    // CVV should be encrypted before storing
    @Column(name = "cvv")
    private String encryptedCvv;

    public Card() {
    }

    public Card(String cardHolderName, String cardNumber, String lastFourDigits, CardType cardType, int balance, BigDecimal creditLimit, String status, String mobileNumber, LocalDate issueDate, LocalDate expiryDate, String encryptedCvv) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.lastFourDigits = lastFourDigits;
        this.cardType = cardType;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.status = status;
        this.mobileNumber = mobileNumber;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.encryptedCvv = encryptedCvv;
    }

    public UUID getCardId() {
        return cardId;
    }

    public void setCardId(UUID cardId) {
        this.cardId = cardId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getEncryptedCvv() {
        return encryptedCvv;
    }

    public void setEncryptedCvv(String encryptedCvv) {
        this.encryptedCvv = encryptedCvv;
    }
}