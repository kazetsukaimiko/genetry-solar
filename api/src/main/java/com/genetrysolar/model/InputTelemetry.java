package com.genetrysolar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genetrysolar.jpa.AllTelemetry;

import java.util.Objects;

public class InputTelemetry extends TelemetryFragment {
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

    @Override
    public String toString() {
        return "InputTelemetry{" +
                "acInput=" + acInput +
                ", chargeAmperage=" + chargeAmperage +
                ", batteryVoltage=" + batteryVoltage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputTelemetry that = (InputTelemetry) o;
        return Objects.equals(acInput, that.acInput) &&
                Objects.equals(chargeAmperage, that.chargeAmperage) &&
                Objects.equals(batteryVoltage, that.batteryVoltage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acInput, chargeAmperage, batteryVoltage);
    }

    @Override
    public void apply(AllTelemetry bucket) {
        bucket.setSourceId(getSourceId());
        bucket.setAcInput(getAcInput());
        bucket.setChargeAmperage(getChargeAmperage());
        bucket.setBatteryVoltage(getBatteryVoltage());
        bucket.setInputTelemetryCollected(true);
    }
}
