package com.challenge.antlia.application.converter;

import com.challenge.antlia.adapters.in.web.response.CosifResponse;
import com.challenge.antlia.domain.model.ProductCosif;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CosifResponseConverter {

    public List<CosifResponse> convert(final List<ProductCosif> source) {
        return source.stream().map(this::toResponse).toList();
    }

    private CosifResponse toResponse(final ProductCosif cosif) {
        return new CosifResponse(
                cosif.productId(),
                cosif.cosifId(),
                cosif.classification(),
                cosif.status()
        );
    }
}
