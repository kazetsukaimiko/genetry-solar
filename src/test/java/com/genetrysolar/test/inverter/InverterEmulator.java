package com.genetrysolar.test.inverter;

import com.genetrysolar.inverter.InverterVariant;
import com.genetrysolar.test.wifiboard.WiFiBoardEmulator;

/**
 * Idea here is the WiFiBoardEmulator will talk to this InverterEmulator interface
 * with PJ and GS variants and vice versa
 */
public interface InverterEmulator {
    InverterVariant getVariant();
    WiFiBoardEmulator getWiFiBoard();
}
