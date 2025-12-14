package com.challenge.antlia.adapters.out.persistence.entity;

import com.challenge.antlia.domain.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUTO")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "COD_PRODUTO")
    private String id;

    @Column(name = "DES_PRODUTO")
    private String description;

    @Column(name = "STA_STATUS")
    private String status;

    public Product toDomain() {
        return new Product(
                this.id,
                this.description,
                this.status
        );
    }
}
