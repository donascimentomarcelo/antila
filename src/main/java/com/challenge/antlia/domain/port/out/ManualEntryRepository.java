package com.challenge.antlia.domain.port.out;

import com.challenge.antlia.domain.model.ManualEntry;

import java.util.List;
import java.util.Optional;

public interface ManualEntryRepository {
    void create(ManualEntry entry);
    List<ManualEntry> findAll();

    Optional<Integer> findTopByMonthAndYearOrderByEntryNumberDesc(Integer month, Integer year);
}
