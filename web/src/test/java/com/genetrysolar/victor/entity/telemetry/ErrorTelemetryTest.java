package com.genetrysolar.victor.entity.telemetry;

import com.genetrysolar.model.ErrorTelemetry;

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
