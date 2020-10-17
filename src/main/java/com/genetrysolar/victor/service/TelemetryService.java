package com.genetrysolar.victor.service;

import com.genetrysolar.victor.service.telemetry.TelemetryRecorder;
import com.genetrysolar.wifiboard.entity.Telemetry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/*
 * Main service for recording telemetry.
 */
@ApplicationScoped
public class TelemetryService implements TelemetryRecorder {

    @Inject @Any
    private Instance<TelemetryRecorder> recorderInstance;

    @Override
    public void record(@Observes @Default Telemetry telemetry) {
        recorderInstance.stream()
                .filter(this::notTelemetryService)
                .forEach(recorder -> recorder.record(telemetry));
    }

    private boolean notTelemetryService(TelemetryRecorder telemetryRecorder) {
        return !(telemetryRecorder instanceof TelemetryService);
    }

    /** TODO : Priorities, quoting Sid
     * Mostly what we would be interested in would be
     * "temperature vs load" charts (particularly inverter temps
     * correlated to ambient temp + load percentage.)
     * Sean may have other ideas;
     */
}
