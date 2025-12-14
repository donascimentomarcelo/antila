package com.challenge.antlia.adapters.in.web.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ManualEntryRequest(
        @NotNull(message = "Entry month is required")
        @Min(value = 1, message = "Month must be between 1 and 12")
        @Max(value = 12, message = "Month must be between 1 and 12")
        Integer entryMonth,

        @NotNull(message = "Entry year is required")
        @Min(value = 1900, message = "Invalid year")
        @Max(value = 2100, message = "Invalid year")
        Integer entryYear,

        @NotBlank(message = "Product id is required")
        @Size(min = 1, max = 4, message = "Product id must have up to 4 characters")
        String entryProductId,

        @NotNull(message = "Amount is required")
        @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
        BigDecimal entryAmount,

        @NotBlank(message = "COSIF is required")
        @Size(min = 1, max = 11, message = "COSIF must have up to 11 characters")
        String entryCosif,

        @NotBlank(message = "Description is required")
        @Size(max = 50, message = "Description must have up to 50 characters")
        String entryDescription) {
}
