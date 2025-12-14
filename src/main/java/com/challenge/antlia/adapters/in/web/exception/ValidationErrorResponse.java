package com.challenge.antlia.adapters.in.web.exception;

import java.time.Instant;
import java.util.List;

public record ValidationErrorResponse(
        int status,
        String message,
        Instant timestamp,
        List<FieldErrorResponse> errors
) {}