package com.challenge.antlia.adapters.out.persistence.adapter;

import com.challenge.antlia.adapters.out.persistence.entity.ManualEntryEntity;
import com.challenge.antlia.adapters.out.persistence.repository.JpaManualEntryRepository;
import com.challenge.antlia.domain.model.ManualEntry;
import com.challenge.antlia.domain.port.out.ManualEntryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ManualEntryRepositoryAdapter implements ManualEntryRepository {

    private final JpaManualEntryRepository jpaManualEntryRepository;

    public ManualEntryRepositoryAdapter(final JpaManualEntryRepository jpaManualEntryRepository) {
        this.jpaManualEntryRepository = jpaManualEntryRepository;
    }

    @Override
    public void create(ManualEntry entry) {
        final var entryEntity = ManualEntryEntity.fromDomain(entry);
        jpaManualEntryRepository.save(entryEntity);
    }

    @Override
    public List<ManualEntry> findAll() {
        final var list = jpaManualEntryRepository.findAll();
        return list.stream().map(ManualEntryEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Integer> findTopByMonthAndYearOrderByEntryNumberDesc(final Integer month, final Integer year) {
        return jpaManualEntryRepository.findTopByIdMonthAndIdYearOrderByIdEntryNumberDesc(month, year)
                .map(item -> item.getId().getEntryNumber());
    }

}
