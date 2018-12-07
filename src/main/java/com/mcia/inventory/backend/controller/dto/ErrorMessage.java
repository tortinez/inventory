package com.mcia.inventory.backend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessage {


    private String type;
    private String message;

    public static ErrorMessage badRequest(String message) {
        return new ErrorMessage("invalid request", message);
    }

    public static ErrorMessage notFound(String message) { return new ErrorMessage("not found", message); }

    public static ErrorMessage conflict(String message) {
        return new ErrorMessage("conflict", message);
    }

    public static ErrorMessage internal(String message) {
        return new ErrorMessage("internal error", message);
    }

}
