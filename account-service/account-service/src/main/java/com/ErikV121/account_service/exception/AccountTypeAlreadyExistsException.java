package com.ErikV121.account_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountTypeAlreadyExistsException extends RuntimeException {
    public AccountTypeAlreadyExistsException(String message) {
        super(message);
    }
}
