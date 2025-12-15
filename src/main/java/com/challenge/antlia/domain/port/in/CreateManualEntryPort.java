package com.challenge.antlia.domain.port.in;

import com.challenge.antlia.domain.model.ManualEntry;

public interface CreateManualEntryPort {
    ManualEntry execute(final ManualEntry command);
}
