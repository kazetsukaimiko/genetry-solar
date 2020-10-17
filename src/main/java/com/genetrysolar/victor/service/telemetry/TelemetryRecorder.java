package com.genetrysolar.victor.service.telemetry;

import com.genetrysolar.wifiboard.entity.Telemetry;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Default;

/**
 * So that we can have multiple data sinks for Telemetry
 * we want to abstract out any
 */
public interface TelemetryRecorder {
    void record(@Observes @Default Telemetry telemetry);
}
