package com.challenge.antlia.adapters.in.web.response;

import java.math.BigDecimal;
import java.util.Date;

public record ManualEntryResponse(
        Integer entryMonth,
        Integer entryYear,
        String entryProductId,
        BigDecimal entryAmount,
        String entryCosif,
        String entryDescription,
        Integer entryNumber,
        Date entryDate,
        String userId
) {
}
