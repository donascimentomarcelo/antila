package com.challenge.antlia.application.converter;

import com.challenge.antlia.adapters.in.web.response.ManualEntryResponse;
import com.challenge.antlia.domain.model.ManualEntry;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManualEntryResponseConverter {

    public List<ManualEntryResponse> convert(final List<ManualEntry> source) {
        return source.stream().map(this::toResponse).toList();
    }

    private ManualEntryResponse toResponse(ManualEntry entry) {
        return new ManualEntryResponse(
                entry.month(),
                entry.year(),
                entry.productId(),
                entry.amount(),
                entry.cosif(),
                entry.description(),
                entry.entryNumber(),
                entry.entryDate(),
                entry.userId()
        );
    }
}
