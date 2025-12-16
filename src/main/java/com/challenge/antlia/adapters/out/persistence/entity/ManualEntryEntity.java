package com.challenge.antlia.adapters.out.persistence.entity;

import com.challenge.antlia.adapters.out.persistence.entity.embedded.ManualEntryId;
import com.challenge.antlia.domain.model.ManualEntry;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "MOVIMENTO_MANUAL")
@Getter
public class ManualEntryEntity {

    @EmbeddedId
    private ManualEntryId id;

    @Column(name = "DES_DESCRICAO")
    private String description;

    @Column(name = "DAT_MOVIMENTO")
    private Date entryDate;

    @Column(name = "COD_USUARIO")
    private String userId;

    @Column(name = "VAL_VALOR")
    private BigDecimal amount;

    protected ManualEntryEntity() {}

    public ManualEntryEntity(final ManualEntryId id, final String description, final Date entryDate,
                             final String userId,
                             final BigDecimal amount) {
        this.id = id;
        this.description = description;
        this.entryDate = entryDate;
        this.userId = userId;
        this.amount = amount;
    }

    public static ManualEntryEntity fromDomain(ManualEntry entry) {
        return new ManualEntryEntity(
                new ManualEntryId(
                        entry.month(),
                        entry.year(),
                        entry.entryNumber(),
                        entry.productId(),
                        entry.cosif()
                ),
                entry.description(),
                entry.entryDate(),
                entry.userId(),
                entry.amount()
        );
    }

    public ManualEntry toDomain() {
        return new ManualEntry(
                this.id.getMonth(),
                this.id.getYear(),
                this.id.getProductId(),
                this.amount,
                this.id.getCosif(),
                this.description,
                this.id.getEntryNumber(),
                this. entryDate,
                this.userId
        );
    }

}
