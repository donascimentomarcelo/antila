package com.challenge.antlia.config;

import com.challenge.antlia.adapters.out.persistence.entity.ProductCosifEntity;
import com.challenge.antlia.adapters.out.persistence.entity.ProductEntity;
import com.challenge.antlia.adapters.out.persistence.entity.embedded.ProductCosifId;
import com.challenge.antlia.adapters.out.persistence.repository.JpaProductCosifRepository;
import com.challenge.antlia.adapters.out.persistence.repository.JpaProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(
            JpaProductRepository productRepository,
            JpaProductCosifRepository productCosifRepository
    ) {
        return args -> {

            ProductEntity p1 = new ProductEntity("0001", "Produto 1", "A");
            ProductEntity p2 = new ProductEntity("0002", "Produto 2", "A");
            ProductEntity p3 = new ProductEntity("0003", "Produto 3", "A");
            ProductEntity p4 = new ProductEntity("0004", "Produto 4", "I");
            ProductEntity p5 = new ProductEntity("0005", "Produto 5", "A");

            productRepository.saveAll(
                    List.of(p1, p2, p3, p4, p5)
            );

            productCosifRepository.saveAll(List.of(
                    new ProductCosifEntity(
                            new ProductCosifId("0001", "COSIF001"),
                            "CL001",
                            "A"
                    ),
                    new ProductCosifEntity(
                            new ProductCosifId("0001", "COSIF002"),
                            "CL002",
                            "A"
                    ),
                    new ProductCosifEntity(
                            new ProductCosifId("0002", "COSIF003"),
                            "CL003",
                            "A"
                    ),
                    new ProductCosifEntity(
                            new ProductCosifId("0003", "COSIF004"),
                            "CL004",
                            "A"
                    ),
                    new ProductCosifEntity(
                            new ProductCosifId("0003", "COSIF005"),
                            "CL005",
                            "A"
                    ),
                    new ProductCosifEntity(
                            new ProductCosifId("0004", "COSIF006"),
                            "CL006",
                            "A"
                    ),
                    new ProductCosifEntity(
                            new ProductCosifId("0005", "COSIF007"),
                            "CL007",
                            "A"
                    )
            ));
        };
    }
}
