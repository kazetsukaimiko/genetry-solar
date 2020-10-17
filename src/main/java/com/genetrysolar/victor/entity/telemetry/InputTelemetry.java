package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputTelemetry {
    public static final String EXAMPLE = "{\"ACin\":0, \"ChrgA\":0, \"BattV\":53.4}";

    @JsonProperty("ACin")
    private Double acInput;

    @JsonProperty("ChrgA")
    private Double chargeAmperage;

    @JsonProperty("BattV")
    private Double batteryVoltage;

    public InputTelemetry() {
    }

    public Double getAcInput() {
        return acInput;
    }

    public void setAcInput(Double acInput) {
        this.acInput = acInput;
    }

    public Double getChargeAmperage() {
        return chargeAmperage;
    }

    public void setChargeAmperage(Double chargeAmperage) {
        this.chargeAmperage = chargeAmperage;
    }

    public Double getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Double batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }
}
