package com.genetrysolar.victor.entity.telemetry;

public class StatusTelemetryTest extends TelemetryTest<StatusTelemetry> {
    @Override
    protected String getExample() {
        return StatusTelemetry.EXAMPLE;
    }

    @Override
    protected Class<StatusTelemetry> getKlazz() {
        return StatusTelemetry.class;
    }
}
