package com.genetrysolar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genetrysolar.jpa.AllTelemetry;

import java.util.Objects;

public class SetupTelemetry extends TelemetryFragment {
    public static final String EXAMPLE = "{\"model\":\"LFPSW-9000-48-220SP\", \"hardver\":0.0, \"UVPa\":41.7, \"UVPe\":39.9, \"OVPa\":58.2, \"OVPe\":60.1, \"ChargeIn\":0}";

    @JsonProperty("model")
    private String model;

    @JsonProperty("hardver")
    private Double hardwareVersion;

    @JsonProperty("UVPa")
    private Double uvAlarmVoltage;

    @JsonProperty("UVPe")
    private Double uvErrorVoltage;

    @JsonProperty("OVPa")
    private Double ovAlarmVoltage;

    @JsonProperty("OVPe")
    private Double ovErrorVoltage;

    @JsonProperty("ChargeIn")
    private Double chargeCapable;

    public SetupTelemetry() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(Double hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public Double getUvAlarmVoltage() {
        return uvAlarmVoltage;
    }

    public void setUvAlarmVoltage(Double uvAlarmVoltage) {
        this.uvAlarmVoltage = uvAlarmVoltage;
    }

    public Double getUvErrorVoltage() {
        return uvErrorVoltage;
    }

    public void setUvErrorVoltage(Double uvErrorVoltage) {
        this.uvErrorVoltage = uvErrorVoltage;
    }

    public Double getOvAlarmVoltage() {
        return ovAlarmVoltage;
    }

    public void setOvAlarmVoltage(Double ovAlarmVoltage) {
        this.ovAlarmVoltage = ovAlarmVoltage;
    }

    public Double getOvErrorVoltage() {
        return ovErrorVoltage;
    }

    public void setOvErrorVoltage(Double ovErrorVoltage) {
        this.ovErrorVoltage = ovErrorVoltage;
    }

    public Double getChargeCapable() {
        return chargeCapable;
    }

    public void setChargeCapable(Double chargeCapable) {
        this.chargeCapable = chargeCapable;
    }

    @Override
    public String toString() {
        return "SetupTelemetry{" +
                "model='" + model + '\'' +
                ", hardwareVersion=" + hardwareVersion +
                ", uvAlarmVoltage=" + uvAlarmVoltage +
                ", uvErrorVoltage=" + uvErrorVoltage +
                ", ovAlarmVoltage=" + ovAlarmVoltage +
                ", ovErrorVoltage=" + ovErrorVoltage +
                ", chargeCapable=" + chargeCapable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetupTelemetry that = (SetupTelemetry) o;
        return Objects.equals(model, that.model) &&
                Objects.equals(hardwareVersion, that.hardwareVersion) &&
                Objects.equals(uvAlarmVoltage, that.uvAlarmVoltage) &&
                Objects.equals(uvErrorVoltage, that.uvErrorVoltage) &&
                Objects.equals(ovAlarmVoltage, that.ovAlarmVoltage) &&
                Objects.equals(ovErrorVoltage, that.ovErrorVoltage) &&
                Objects.equals(chargeCapable, that.chargeCapable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, hardwareVersion, uvAlarmVoltage, uvErrorVoltage, ovAlarmVoltage, ovErrorVoltage, chargeCapable);
    }

    @Override
    public void apply(AllTelemetry bucket) {
        bucket.setSourceId(getSourceId());
        bucket.setModel(getModel());
        bucket.setHardwareVersion(getHardwareVersion());
        bucket.setUvAlarmVoltage(getUvAlarmVoltage());
        bucket.setUvErrorVoltage(getUvErrorVoltage());
        bucket.setOvAlarmVoltage(getOvAlarmVoltage());
        bucket.setOvErrorVoltage(getOvErrorVoltage());
        bucket.setChargeCapable(getChargeCapable());
        bucket.setSetupTelemetryCollected(true);
    }
}
