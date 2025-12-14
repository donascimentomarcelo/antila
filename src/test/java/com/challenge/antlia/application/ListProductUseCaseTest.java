package com.challenge.antlia.application;

import com.challenge.antlia.application.usecase.ListProductUseCase;
import com.challenge.antlia.domain.model.Product;
import com.challenge.antlia.domain.port.out.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListProductUseCaseTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ListProductUseCase useCase;

    @Test
    public void itShouldExecuteSuccessfully() {

        List<Product> list = new ArrayList<>();
        list.add(new Product( "PD01", "any desc", "A"));

        when(repository.findAll())
                .thenReturn(list);

        List<Product> actual = useCase.execute();

        assertThat(actual).isEqualTo(list);
    }
}
