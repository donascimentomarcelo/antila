package com.challenge.antlia.application.converter;

import com.challenge.antlia.adapters.in.web.response.ManualEntryResponse;
import com.challenge.antlia.domain.model.ManualEntry;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ManualEntryResponseConverter implements Converter<ManualEntry, ManualEntryResponse> {
    @Override
    public ManualEntryResponse convert(final ManualEntry source) {
        return new ManualEntryResponse(
                source.month(),
                source.year(),
                source.productId(),
                source.amount(),
                source.cosif(),
                source.description(),
                source.entryNumber(),
                source.entryDate(),
                source.userId());
    }
}
