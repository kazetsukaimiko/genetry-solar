package com.genetrysolar.victor.entity.telemetry;

public class FanTelemetryTest extends TelemetryTest<FanTelemetry> {
    @Override
    protected String getExample() {
        return FanTelemetry.EXAMPLE;
    }

    @Override
    protected Class<FanTelemetry> getKlazz() {
        return FanTelemetry.class;
    }
}
