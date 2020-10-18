package com.genetrysolar.victor.entity.telemetry;

import com.genetrysolar.model.TemperatureTelemetry;

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
