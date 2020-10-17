package com.genetrysolar.test.wifiboard;

import com.genetrysolar.test.inverter.InverterEmulator;
import com.genetrysolar.wifiboard.entity.Telemetry;

/**
 * Stub interface to send WiFi board events
 */
public interface WiFiBoardEmulator {
    void sendTelemetry(Telemetry telemetry);

    InverterEmulator getInverter();
}
