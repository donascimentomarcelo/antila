package com.challenge.antlia.adapters.out.persistence.repository;

import com.challenge.antlia.adapters.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, String> {
}
