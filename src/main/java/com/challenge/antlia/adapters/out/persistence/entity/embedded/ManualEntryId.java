package com.challenge.antlia.adapters.out.persistence.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
public class ManualEntryId implements Serializable {
    @Column(name = "DAT_MES")
    private Integer month;

    @Column(name = "DAT_ANO")
    private Integer year;

    @Column(name = "NUM_MOVIMENTO")
    private Integer entryNumber;

    @Column(name = "COD_PRODUTO")
    private String productId;

    @Column(name = "COD_COSIF")
    private String cosif;

    protected ManualEntryId() {}

    public ManualEntryId(
            Integer month,
            Integer year,
            Integer entryNumber,
            String productId,
            String cosif
    ) {
        this.month = month;
        this.year = year;
        this.entryNumber = entryNumber;
        this.productId = productId;
        this.cosif = cosif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManualEntryId that)) return false;
        return Objects.equals(month, that.month)
                && Objects.equals(year, that.year)
                && Objects.equals(entryNumber, that.entryNumber)
                && Objects.equals(productId, that.productId)
                && Objects.equals(cosif, that.cosif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, year, entryNumber, productId, cosif);
    }
}
