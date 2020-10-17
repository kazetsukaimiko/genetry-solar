package com.genetrysolar.victor.entity.telemetry;

public class InputTelemetryTest extends TelemetryTest<InputTelemetry> {
    @Override
    protected String getExample() {
        return InputTelemetry.EXAMPLE;
    }

    @Override
    protected Class<InputTelemetry> getKlazz() {
        return InputTelemetry.class;
    }
}
