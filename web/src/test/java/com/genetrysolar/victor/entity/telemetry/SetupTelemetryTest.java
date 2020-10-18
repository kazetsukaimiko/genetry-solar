package com.genetrysolar.victor.entity.telemetry;

import com.genetrysolar.model.SetupTelemetry;

public class SetupTelemetryTest extends TelemetryTest<SetupTelemetry> {
    @Override
    protected String getExample() {
        return SetupTelemetry.EXAMPLE;
    }

    @Override
    protected Class<SetupTelemetry> getKlazz() {
        return SetupTelemetry.class;
    }
}
