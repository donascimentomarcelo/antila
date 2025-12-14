package com.challenge.antlia.adapters.web;

import jakarta.inject.Named;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static net.bytebuddy.matcher.ElementMatchers.isArray;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CosifControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Named("should retrieve one cosif when the product id is valid")
    void shouldRetrieveOneCosifWhenTheProductIdIsValid() throws Exception {

        mockMvc.perform(get("/cosifs/product/{productId}", "0001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$").isArray(),
                        jsonPath("$[0].productId").value("0001"),
                        jsonPath("$[0].cosifId").value("COSIF001"),
                        jsonPath("$[0].classification").value("CL001"),
                        jsonPath("$[0].status").value("A")
                );
    }

    @Test
    @Named("should retrieve and empty array when the product id is not valid")
    void shouldRetrieveAnEmptyArrayWhenTheProductIdIsNotValid() throws Exception {

        mockMvc.perform(get("/cosifs/product/{productId}", "0009")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }
}
