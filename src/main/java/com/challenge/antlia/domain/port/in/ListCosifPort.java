package com.challenge.antlia.domain.port.in;

import com.challenge.antlia.domain.model.ProductCosif;

import java.util.List;

public interface ListCosifPort {
    List<ProductCosif> execute(String productId);
}
