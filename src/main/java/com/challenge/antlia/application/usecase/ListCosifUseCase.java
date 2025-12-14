package com.challenge.antlia.application.usecase;

import com.challenge.antlia.domain.model.ProductCosif;
import com.challenge.antlia.domain.port.in.ListCosifPort;
import com.challenge.antlia.domain.port.out.ProductCosifRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListCosifUseCase implements ListCosifPort {

    private final ProductCosifRepository productCosifRepository;

    public ListCosifUseCase(final ProductCosifRepository productCosifRepository) {
        this.productCosifRepository = productCosifRepository;
    }

    @Override
    public List<ProductCosif> execute(final String productId) {
        return productCosifRepository.findTopByIdProductId(productId);
    }
}
