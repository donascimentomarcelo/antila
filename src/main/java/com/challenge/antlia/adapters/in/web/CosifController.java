package com.challenge.antlia.adapters.in.web;

import com.challenge.antlia.adapters.in.web.response.CosifResponse;
import com.challenge.antlia.application.converter.CosifResponseConverter;
import com.challenge.antlia.domain.model.ProductCosif;
import com.challenge.antlia.domain.port.in.ListCosifPort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cosifs")
@AllArgsConstructor
public class CosifController {

    private final ListCosifPort listCosifPort;
    private final CosifResponseConverter converter;

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<CosifResponse>> getCosif(@PathVariable String productId) {
        List<ProductCosif> cosif = listCosifPort.execute(productId);
        var cosifResponse = converter.convert(cosif);
        return ResponseEntity.ok(cosifResponse);
    }
}
