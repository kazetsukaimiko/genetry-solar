package com.genetrysolar.victor.service.telemetry;

import com.genetrysolar.victor.entity.telemetry.TelemetryFragment;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Default;
import java.io.IOException;

/**
 * So that we can have multiple data sinks for Telemetry
 * we want to abstract out any
 */
public interface TelemetryRecorder {
    void record(@Observes @Default TelemetryFragment telemetry) throws IOException;
}
