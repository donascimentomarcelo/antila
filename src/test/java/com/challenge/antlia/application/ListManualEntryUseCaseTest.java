package com.challenge.antlia.application;

import com.challenge.antlia.application.usecase.ListManualEntriesUseCase;
import com.challenge.antlia.domain.model.ManualEntry;
import com.challenge.antlia.domain.port.out.ManualEntryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListManualEntryUseCaseTest {

    @Mock
    private ManualEntryRepository manualEntryRepository;

    @InjectMocks
    private ListManualEntriesUseCase useCase;

    @Test
    public void itShouldExecuteSuccessfully() {

        List<ManualEntry> list = new ArrayList<>();
        list.add(new ManualEntry(1, 2025, "PD01", BigDecimal.valueOf(900000L), "COSIF01", "any desc", null, null ,
                "TESTE"));

        when(manualEntryRepository.findAll())
                .thenReturn(list);

        List<ManualEntry> actual = useCase.execute();

        assertThat(actual).isEqualTo(list);
    }
}
