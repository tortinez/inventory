package com.mcia.inventory.backend.service.exception;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String s) {
        super(s);
    }

    public InvalidRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidRequestException(Throwable throwable) {
        super(throwable);
    }
}