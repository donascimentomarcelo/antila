package com.challenge.antlia.application.usecase;

import com.challenge.antlia.domain.model.ManualEntry;
import com.challenge.antlia.domain.port.in.ListManualEntriesPort;
import com.challenge.antlia.domain.port.out.ManualEntryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListManualEntriesUseCase implements ListManualEntriesPort {

    private final ManualEntryRepository manualEntryRepository;

    public ListManualEntriesUseCase(final ManualEntryRepository manualEntryRepository) {
        this.manualEntryRepository = manualEntryRepository;
    }

    @Override
    public List<ManualEntry> execute() {
        return manualEntryRepository.findAll();
    }
}
