package com.challenge.antlia.web;

import com.challenge.antlia.adapters.in.web.ManualEntryController;
import com.challenge.antlia.application.converter.ManualEntryResponseConverter;
import com.challenge.antlia.domain.port.in.CreateManualEntryPort;
import com.challenge.antlia.domain.port.in.ListManualEntriesPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ManualEntryController.class)
public class ManuelEntryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CreateManualEntryPort createManualEntryPort;

    @MockitoBean
    ListManualEntriesPort listManualEntriesPort;

    @MockitoBean
    ManualEntryResponseConverter manualEntryResponseConverter;

    @Test
    void shouldCreateManualEntry() throws Exception {
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
}
