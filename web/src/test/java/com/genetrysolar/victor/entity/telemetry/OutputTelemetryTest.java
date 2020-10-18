package com.genetrysolar.victor.entity.telemetry;

import com.genetrysolar.model.OutputTelemetry;

public class OutputTelemetryTest extends TelemetryTest<OutputTelemetry> {
    @Override
    protected String getExample() {
        return OutputTelemetry.EXAMPLE;
    }

    @Override
    protected Class<OutputTelemetry> getKlazz() {
        return OutputTelemetry.class;
    }
}
