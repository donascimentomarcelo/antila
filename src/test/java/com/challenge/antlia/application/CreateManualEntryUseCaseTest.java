package com.challenge.antlia.application;

import com.challenge.antlia.application.usecase.CreateManualEntryUseCase;
import com.challenge.antlia.domain.model.ManualEntry;
import com.challenge.antlia.domain.port.in.CreateManualEntryPort;
import com.challenge.antlia.domain.port.out.ManualEntryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.ExpectedCount.once;

@ExtendWith(MockitoExtension.class)
public class CreateManualEntryUseCaseTest {

    @Mock
    private ManualEntryRepository manualEntryRepository;

    @InjectMocks
    private CreateManualEntryUseCase useCase;

    @Test
    public void itShouldExecuteSuccessfully() {

        when(manualEntryRepository.findTopByMonthAndYearOrderByEntryNumberDesc(any(), any()))
                .thenReturn(Optional.of(20));

        final var entry = new ManualEntry(1, 2025, "PD01", BigDecimal.valueOf(900000L), "COSIF01", "any desc", null,
                null ,"TESTE");

        useCase.execute(entry);

        verify(manualEntryRepository, times(1)).create(any());
    }

    @Test
    public void itShouldExecuteSuccessfullyWhenThereIsNoManualEntry() {

        when(manualEntryRepository.findTopByMonthAndYearOrderByEntryNumberDesc(any(), any()))
                .thenReturn(Optional.empty());

        final var entry = new ManualEntry(1, 2025, "PD01", BigDecimal.valueOf(900000L), "COSIF01", "any desc", null,
                null ,"TESTE");

        useCase.execute(entry);

        verify(manualEntryRepository, times(1)).create(any());
    }
}
