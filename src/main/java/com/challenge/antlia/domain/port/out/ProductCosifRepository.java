package com.challenge.antlia.domain.port.out;

import com.challenge.antlia.domain.model.ProductCosif;

import java.util.List;

public interface ProductCosifRepository {
    List<ProductCosif> findTopByIdProductId(String productId);
}
