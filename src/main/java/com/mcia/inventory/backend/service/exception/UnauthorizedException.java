package com.mcia.inventory.backend.service.exception;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String s) {
        super(s);
    }

    public UnauthorizedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UnauthorizedException(Throwable throwable) {
        super(throwable);
    }
}