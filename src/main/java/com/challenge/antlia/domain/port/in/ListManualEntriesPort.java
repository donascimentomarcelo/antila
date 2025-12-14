package com.challenge.antlia.domain.port.in;

import com.challenge.antlia.domain.model.ManualEntry;

import java.util.List;

public interface ListManualEntriesPort {
    List<ManualEntry> execute();
}
