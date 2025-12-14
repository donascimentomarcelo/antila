package com.challenge.antlia.adapters.in.web;

import com.challenge.antlia.adapters.in.web.response.ProductResponse;
import com.challenge.antlia.application.converter.ProductResponseConverter;
import com.challenge.antlia.domain.model.Product;
import com.challenge.antlia.domain.port.in.ListProductPort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ListProductPort listProductPort;
    private final ProductResponseConverter converter;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<Product> list = listProductPort.execute();
        var response = converter.convert(list);
        return ResponseEntity.ok(response);
    }
}
