package com.example.expenseapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ItemAlreadyExitsException extends  RuntimeException {
    public ItemAlreadyExitsException(String message) {
        super(message);
    }
}
