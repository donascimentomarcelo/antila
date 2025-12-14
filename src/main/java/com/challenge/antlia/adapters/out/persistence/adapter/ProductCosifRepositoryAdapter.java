package com.challenge.antlia.adapters.out.persistence.adapter;

import com.challenge.antlia.adapters.out.persistence.entity.ProductCosifEntity;
import com.challenge.antlia.adapters.out.persistence.repository.JpaProductCosifRepository;
import com.challenge.antlia.domain.model.ProductCosif;
import com.challenge.antlia.domain.port.out.ProductCosifRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductCosifRepositoryAdapter implements ProductCosifRepository {

    private JpaProductCosifRepository jpaProductCosifRepository;


    @Override
    public List<ProductCosif> findTopByIdProductId(final String productId) {
        List<ProductCosifEntity> list = jpaProductCosifRepository.findTopByIdProductId(productId);
        return list.stream().map(ProductCosifEntity::toDomain).toList();
    }
}
