package com.challenge.antlia.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public record ManualEntry(
        Integer month,
        Integer year,
        String productId,
        BigDecimal amount,
        String cosif,
        String description,
        Integer entryNumber,
        Date entryDate,
        Integer userId) {
}