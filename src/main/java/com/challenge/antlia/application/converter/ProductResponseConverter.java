package com.challenge.antlia.application.converter;

import com.challenge.antlia.adapters.in.web.response.ProductResponse;
import com.challenge.antlia.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductResponseConverter {

    public List<ProductResponse> convert(final List<Product> source) {
        return source.stream().map(this::toResponse).toList();
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.productId(),
                product.description(),
                product.status()
        );
    }
}
