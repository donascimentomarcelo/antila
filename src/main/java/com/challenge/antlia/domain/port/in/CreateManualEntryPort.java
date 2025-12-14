package com.challenge.antlia.domain.port.in;

import com.challenge.antlia.domain.model.ManualEntry;

public interface CreateManualEntryPort {
    void execute(ManualEntry command);
}
