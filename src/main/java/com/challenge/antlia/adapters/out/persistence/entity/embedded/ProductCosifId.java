package com.challenge.antlia.adapters.out.persistence.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
public class ProductCosifId implements Serializable {
    @Column(name = "COD_PRODUTO")
    private String productId;

    @Column(name = "COD_COSIF")
    private String cosif;

    protected ProductCosifId() {}

    public ProductCosifId(final String productId, final String cosif) {
        this.productId = productId;
        this.cosif = cosif;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ProductCosifId that = (ProductCosifId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(cosif, that.cosif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, cosif);
    }
}
