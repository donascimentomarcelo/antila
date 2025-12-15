package com.challenge.antlia.adapters.web;

import com.challenge.antlia.application.converter.ManualEntryListConverter;
import com.challenge.antlia.domain.port.in.CreateManualEntryPort;
import com.challenge.antlia.domain.port.in.ListManualEntriesPort;
import jakarta.inject.Named;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ManualEntryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CreateManualEntryPort createManualEntryPort;

    @MockitoBean
    ListManualEntriesPort listManualEntriesPort;

    @MockitoBean
    ManualEntryListConverter manualEntryResponseConverter;

    @Test
    @Named("should create a manual entry successfully")
    void shouldCreateAManualEntrySuccessfully() throws Exception {
        var body = """
                {
                    "entryMonth": 1,
                    "entryYear": 2024,
                    "entryProductId": "123",
                    "entryAmount": 1000.50,
                    "entryCosif": "COSIF001",
                    "entryDescription": "Descrição do lançamento"
                }
                """;
        mockMvc.perform(post("/manual-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    @Test
    @Named("should not create a manual entry when month is empty")
    void shouldNotCreateAManualEntryWhenMonthIsEmpty() throws Exception {
        var body = """
                {
                    "entryMonth": null,
                    "entryYear": 2024,
                    "entryProductId": "123",
                    "entryAmount": 1000.50,
                    "entryCosif": "COSIF001",
                    "entryDescription": "Descrição do lançamento"
                }
                """;
        mockMvc.perform(post("/manual-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpectAll(
                        status().isBadRequest(),
                        jsonPath("message", is( "Validation error")),
                        jsonPath("timestamp", notNullValue()),
                        jsonPath("errors", hasItem(
                                allOf(
                                        hasEntry("field", "entryMonth"),
                                        hasEntry("message", "Entry month is required")
                                )
                        ))
                );
    }

    @Test
    @Named("should not create a manual entry when year is empty")
    void shouldNotCreateAManualEntryWhenYearIsEmpty() throws Exception {
        var body = """
                {
                    "entryMonth": 1,
                    "entryYear": null,
                    "entryProductId": "123",
                    "entryAmount": 1000.50,
                    "entryCosif": "COSIF001",
                    "entryDescription": "Descrição do lançamento"
                }
                """;
        mockMvc.perform(post("/manual-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpectAll(
                        status().isBadRequest(),
                        jsonPath("message", is( "Validation error")),
                        jsonPath("timestamp", notNullValue()),
                        jsonPath("errors", hasItem(
                                allOf(
                                        hasEntry("field", "entryYear"),
                                        hasEntry("message", "Entry year is required")
                                )
                        ))
                );
    }

    @Test
    @Named("should not create a manual entry when product is empty")
    void shouldNotCreateAManualEntryWhenProductIsEmpty() throws Exception {
        var body = """
                {
                    "entryMonth": 1,
                    "entryYear": 2025,
                    "entryProductId": null,
                    "entryAmount": 1000.50,
                    "entryCosif": "COSIF001",
                    "entryDescription": "Descrição do lançamento"
                }
                """;
        mockMvc.perform(post("/manual-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpectAll(
                        status().isBadRequest(),
                        jsonPath("message", is( "Validation error")),
                        jsonPath("timestamp", notNullValue()),
                        jsonPath("errors", hasItem(
                                allOf(
                                        hasEntry("field", "entryProductId"),
                                        hasEntry("message", "Product is required")
                                )
                        ))
                );
    }

    @Test
    @Named("should not create a manual entry when amount is empty")
    void shouldNotCreateAManualEntryWhenAmountIsEmpty() throws Exception {
        var body = """
                {
                    "entryMonth": 1,
                    "entryYear": 2025,
                    "entryProductId": 1,
                    "entryAmount": null,
                    "entryCosif": "COSIF001",
                    "entryDescription": "Descrição do lançamento"
                }
                """;
        mockMvc.perform(post("/manual-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpectAll(
                        status().isBadRequest(),
                        jsonPath("message", is( "Validation error")),
                        jsonPath("timestamp", notNullValue()),
                        jsonPath("errors", hasItem(
                                allOf(
                                        hasEntry("field", "entryAmount"),
                                        hasEntry("message", "Amount is required")
                                )
                        ))
                );
    }

    @Test
    @Named("should not create a manual entry when amount is negative")
    void shouldNotCreateAManualEntryWhenAmountIsNegative() throws Exception {
        var body = """
                {
                    "entryMonth": 1,
                    "entryYear": 2025,
                    "entryProductId": 1,
                    "entryAmount": -1,
                    "entryCosif": "COSIF001",
                    "entryDescription": "Descrição do lançamento"
                }
                """;
        mockMvc.perform(post("/manual-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpectAll(
                        status().isBadRequest(),
                        jsonPath("message", is( "Validation error")),
                        jsonPath("timestamp", notNullValue()),
                        jsonPath("errors", hasItem(
                                allOf(
                                        hasEntry("field", "entryAmount"),
                                        hasEntry("message", "Amount must be greater than zero")
                                )
                        ))
                );
    }

    @Test
    @Named("should not create a manual entry when COSIF is empty")
    void shouldNotCreateAManualEntryWhenCOSIFIsEmpty() throws Exception {
        var body = """
                {
                    "entryMonth": 1,
                    "entryYear": 2025,
                    "entryProductId": 1,
                    "entryAmount": 10.000,
                    "entryCosif": null,
                    "entryDescription": "Descrição do lançamento"
                }
                """;
        mockMvc.perform(post("/manual-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpectAll(
                        status().isBadRequest(),
                        jsonPath("message", is( "Validation error")),
                        jsonPath("timestamp", notNullValue()),
                        jsonPath("errors", hasItem(
                                allOf(
                                        hasEntry("field", "entryCosif"),
                                        hasEntry("message", "COSIF is required")
                                )
                        ))
                );
    }

    @Test
    @Named("should not create a manual entry when COSIF is greater than eleven characters")
    void shouldNotCreateAManualEntryWhenCOSIFIsGreaterThanElevenCharacters() throws Exception {
        var body = """
                {
                    "entryMonth": 1,
                    "entryYear": 2025,
                    "entryProductId": 1,
                    "entryAmount": 10.000,
                    "entryCosif": "RamdomCosif0001",
                    "entryDescription": "Descrição do lançamento"
                }
                """;
        mockMvc.perform(post("/manual-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpectAll(
                        status().isBadRequest(),
                        jsonPath("message", is( "Validation error")),
                        jsonPath("timestamp", notNullValue()),
                        jsonPath("errors", hasItem(
                                allOf(
                                        hasEntry("field", "entryCosif"),
                                        hasEntry("message", "COSIF must have up to 11 characters")
                                )
                        ))
                );
    }

    @Test
    @Named("should not create a manual entry when Description is empty")
    void shouldNotCreateAManualEntryWhenDescriptionIsEmpty() throws Exception {
        var body = """
                {
                    "entryMonth": 1,
                    "entryYear": 2025,
                    "entryProductId": 1,
                    "entryAmount": 10.000,
                    "entryCosif": "COSIF001",
                    "entryDescription": null
                }
                """;
        mockMvc.perform(post("/manual-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpectAll(
                        status().isBadRequest(),
                        jsonPath("message", is( "Validation error")),
                        jsonPath("timestamp", notNullValue()),
                        jsonPath("errors", hasItem(
                                allOf(
                                        hasEntry("field", "entryDescription"),
                                        hasEntry("message", "Description is required")
                                )
                        ))
                );
    }
}
