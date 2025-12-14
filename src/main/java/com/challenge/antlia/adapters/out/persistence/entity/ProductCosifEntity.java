package com.challenge.antlia.adapters.out.persistence.entity;

import com.challenge.antlia.adapters.out.persistence.entity.embedded.ProductCosifId;
import com.challenge.antlia.domain.model.ProductCosif;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUTO_COSIF")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCosifEntity {

    @EmbeddedId
    private ProductCosifId id;

    @Column(name = "COD_CLASSIFICACAO")
    private String classificationCode;

    @Column(name = "STA_STATUS")
    private String status;

    public ProductCosif toDomain() {
        return new ProductCosif(
                this.id.getProductId(),
                this.id.getCosif(),
                this.getClassificationCode(),
                this.getStatus()
        );
    }
}
