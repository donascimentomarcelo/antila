package com.challenge.antlia.application.converter;

import com.challenge.antlia.adapters.in.web.dto.ManualEntryRequest;
import com.challenge.antlia.domain.model.ManualEntry;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ManualEntryRequestConverter implements Converter<ManualEntryRequest, ManualEntry> {
    @Override
    public ManualEntry convert(final ManualEntryRequest source) {
        return new ManualEntry(
                source.entryMonth(),
                source.entryYear(),
                source.entryProductId(),
                source.entryAmount(),
                source.entryCosif(),
                source.entryDescription(),
                null,
                new Date(),
                1); // pega o id do usuario
    }
}
