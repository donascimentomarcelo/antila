package com.challenge.antlia.domain.port.in;

import com.challenge.antlia.domain.model.Product;

import java.util.List;

public interface ListProductPort {
    List<Product> execute();
}
