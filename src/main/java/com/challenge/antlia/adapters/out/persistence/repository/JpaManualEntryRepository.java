package com.challenge.antlia.adapters.out.persistence.repository;

import com.challenge.antlia.adapters.out.persistence.entity.ManualEntryEntity;
import com.challenge.antlia.adapters.out.persistence.entity.embedded.ManualEntryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaManualEntryRepository extends JpaRepository<ManualEntryEntity, ManualEntryId> {
    Optional<ManualEntryEntity> findTopByIdMonthAndIdYearOrderByIdEntryNumberDesc(Integer month, Integer year);
}
