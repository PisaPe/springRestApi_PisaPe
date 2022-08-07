package com.example.chiquita.model;

public record ErrorResponse(String message, ErrorCodes errorCodes, Integer status) {
}
