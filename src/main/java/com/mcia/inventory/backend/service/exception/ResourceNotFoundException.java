package com.mcia.inventory.backend.service.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ResourceNotFoundException(Throwable throwable) {
        super(throwable);
    }
}