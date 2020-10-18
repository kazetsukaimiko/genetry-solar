package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genetrysolar.jpa.AllTelemetry;

import java.time.Instant;

public abstract class TelemetryFragment {
    // Where/what client did this come from
    @JsonIgnore
    private String sourceId;

    @JsonIgnore
    private final Instant created = Instant.now();

    public abstract void apply(AllTelemetry bucket);

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Instant getCreated() {
        return created;
    }
}
