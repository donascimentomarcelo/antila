package com.challenge.antlia.adapters.out.persistence.adapter;

import com.challenge.antlia.adapters.out.persistence.entity.ProductEntity;
import com.challenge.antlia.adapters.out.persistence.repository.JpaProductRepository;
import com.challenge.antlia.domain.model.Product;
import com.challenge.antlia.domain.port.out.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private JpaProductRepository jpaProductRepository;

    @Override
    public List<Product> findAll() {
        return jpaProductRepository
                .findAll()
                .stream()
                .map(ProductEntity::toDomain).toList();
    }
}
