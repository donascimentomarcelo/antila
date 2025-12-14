package com.challenge.antlia.adapters.web;

import jakarta.inject.Named;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Named("should retrieve all products successfully")
    void shouldRetrieveAllProductsSuccessfully() throws Exception {

        mockMvc.perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("[0].productId", is("0001")),
                        jsonPath("[0].description", is("Produto 1")),
                        jsonPath("[0].status", is("A")),

                        jsonPath("[1].productId", is("0002")),
                        jsonPath("[1].description", is("Produto 2")),
                        jsonPath("[1].status", is("A")),

                        jsonPath("[2].productId", is("0003")),
                        jsonPath("[2].description", is("Produto 3")),
                        jsonPath("[2].status", is("A")),

                        jsonPath("[3].productId", is("0004")),
                        jsonPath("[3].description", is("Produto 4")),
                        jsonPath("[3].status", is("I")),

                        jsonPath("[4].productId", is("0005")),
                        jsonPath("[4].description", is("Produto 5")),
                        jsonPath("[4].status", is("A"))
                );
    }
}
