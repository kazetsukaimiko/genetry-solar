package com.genetrysolar.victor.entity.telemetry;

public class TemperatureTelemetryTest extends TelemetryTest<TemperatureTelemetry> {
    @Override
    protected String getExample() {
        return TemperatureTelemetry.EXAMPLE;
    }

    @Override
    protected Class<TemperatureTelemetry> getKlazz() {
        return TemperatureTelemetry.class;
    }
}
