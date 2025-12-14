package com.challenge.antlia.domain.port.out;

import com.challenge.antlia.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
