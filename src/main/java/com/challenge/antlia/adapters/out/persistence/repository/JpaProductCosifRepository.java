package com.challenge.antlia.adapters.out.persistence.repository;

import com.challenge.antlia.adapters.out.persistence.entity.ProductCosifEntity;
import com.challenge.antlia.adapters.out.persistence.entity.embedded.ProductCosifId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductCosifRepository extends JpaRepository<ProductCosifEntity, ProductCosifId> {
    List<ProductCosifEntity> findTopByIdProductId(String productId);
}
