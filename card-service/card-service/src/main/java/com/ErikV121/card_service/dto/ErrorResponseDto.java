package com.ErikV121.card_service.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        HttpStatus errorCode,
        String errorMessage,
        String apiPath,
        LocalDateTime timestamp) {}
