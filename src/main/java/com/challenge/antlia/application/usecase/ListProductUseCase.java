package com.challenge.antlia.application.usecase;

import com.challenge.antlia.domain.model.Product;
import com.challenge.antlia.domain.port.in.ListProductPort;
import com.challenge.antlia.domain.port.out.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListProductUseCase implements ListProductPort {

    private final ProductRepository productRepository;

    public ListProductUseCase(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> execute() {
        return productRepository.findAll();
    }
}
