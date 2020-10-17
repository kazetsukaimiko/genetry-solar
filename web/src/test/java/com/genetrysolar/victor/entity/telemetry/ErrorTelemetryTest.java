package com.genetrysolar.victor.entity.telemetry;

public class ErrorTelemetryTest extends TelemetryTest<ErrorTelemetry> {
    @Override
    protected String getExample() {
        return ErrorTelemetry.EXAMPLE;
    }

    @Override
    protected Class<ErrorTelemetry> getKlazz() {
        return ErrorTelemetry.class;
    }
}
