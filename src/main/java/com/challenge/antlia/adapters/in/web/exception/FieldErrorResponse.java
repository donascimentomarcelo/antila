package com.challenge.antlia.adapters.in.web.exception;

public record FieldErrorResponse(
        String field,
        String message
) {}