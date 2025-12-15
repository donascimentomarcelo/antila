package com.challenge.antlia.adapters.in.web;

import com.challenge.antlia.adapters.in.web.dto.ManualEntryRequest;
import com.challenge.antlia.adapters.in.web.response.ManualEntryResponse;
import com.challenge.antlia.application.converter.ManualEntryListConverter;
import com.challenge.antlia.domain.model.ManualEntry;
import com.challenge.antlia.domain.port.in.CreateManualEntryPort;
import com.challenge.antlia.domain.port.in.ListManualEntriesPort;
import jakarta.validation.Valid;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manual-entries")
public class ManualEntryController {

    private final CreateManualEntryPort createManualEntryPort;
    private final ListManualEntriesPort listManualEntriesPort;
    private final ConversionService conversionService;
    private final ManualEntryListConverter manualEntryRequestConverter;

    public ManualEntryController(CreateManualEntryPort createManualEntryPort, final ListManualEntriesPort listManualEntriesPort,
                                 final ConversionService conversionService, final ManualEntryListConverter manualEntryRequestConverter) {
        this.createManualEntryPort = createManualEntryPort;
        this.listManualEntriesPort = listManualEntriesPort;
        this.conversionService = conversionService;
        this.manualEntryRequestConverter = manualEntryRequestConverter;
    }

    @PostMapping
    public ResponseEntity<ManualEntryResponse> createManualEntry(@RequestBody @Valid ManualEntryRequest request) {
        var manualEntry = conversionService.convert(request, ManualEntry.class);
        final ManualEntry response = createManualEntryPort.execute(manualEntry);
        var manualEntryResponse = conversionService.convert(response, ManualEntryResponse.class);
        return ResponseEntity.ok(manualEntryResponse);
    }

    @GetMapping
    public ResponseEntity<List<ManualEntryResponse>>getManualEntry() {
        List<ManualEntry> entryList = listManualEntriesPort.execute();
        var manualEntry = manualEntryRequestConverter.convert(entryList);
        return ResponseEntity.ok(manualEntry);
    }
}
