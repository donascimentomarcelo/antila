package com.challenge.antlia.application;

import com.challenge.antlia.application.usecase.ListCosifUseCase;
import com.challenge.antlia.domain.model.ProductCosif;
import com.challenge.antlia.domain.port.out.ProductCosifRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListCosifUseCaseTest {

    @Mock
    private ProductCosifRepository repository;

    @InjectMocks
    private ListCosifUseCase useCase;

    @Test
    public void itShouldExecuteSuccessfully() {

        List<ProductCosif> list = new ArrayList<>();
        list.add(new ProductCosif( "PD01","COSIF01", "any desc", "A"));

        when(repository.findTopByIdProductId(anyString()))
                .thenReturn(list);

        List<ProductCosif> actual = useCase.execute("PD01");

        assertThat(actual).isEqualTo(list);
    }
}
