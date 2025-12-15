package com.challenge.antlia.application.usecase;

import com.challenge.antlia.domain.model.ManualEntry;
import com.challenge.antlia.domain.port.in.CreateManualEntryPort;
import com.challenge.antlia.domain.port.out.ManualEntryRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreateManualEntryUseCase implements CreateManualEntryPort {

    private final ManualEntryRepository manualEntryRepository;

    public CreateManualEntryUseCase(final ManualEntryRepository manualEntryRepository) {
        this.manualEntryRepository = manualEntryRepository;
    }

    @Override
    public ManualEntry execute(ManualEntry manualEntry) {

        Integer nextEntryNumber = manualEntryRepository
                    .findTopByMonthAndYearOrderByEntryNumberDesc(manualEntry.month(), manualEntry.year())
                    .map(last -> last + 1)
                    .orElse(1);

        ManualEntry entryToSave = new ManualEntry(
                manualEntry.month(),
                manualEntry.year(),
                manualEntry.productId(),
                manualEntry.amount(),
                manualEntry.cosif(),
                manualEntry.description(),
                nextEntryNumber,
                new Date(),
                manualEntry.userId()
        );


        return manualEntryRepository.create(entryToSave);
    }
}
