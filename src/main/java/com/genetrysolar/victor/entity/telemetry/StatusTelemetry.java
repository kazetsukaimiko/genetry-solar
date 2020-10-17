package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genetrysolar.victor.entity.telemetry.enumerations.InverterModes;
import com.genetrysolar.victor.entity.telemetry.enumerations.PowerStatus;

public class StatusTelemetry {
    public static final String EXAMPLE = " {\"invmode\":2, \"power\":2, \"hrs\":8109, \"KWh\":96, \"Ver\":\"1.0r16\"}";

    // TODO: Make sure these deserialize by ordinal.

    @JsonProperty("invmode")
    private InverterModes inverterModes;

    @JsonProperty("power")
    private PowerStatus power;

    @JsonProperty("hrs")
    private Integer hours;

    @JsonProperty("KWh")
    private Integer kWh;

    @JsonProperty("Ver")
    private String version;

    public StatusTelemetry() {
    }

    public InverterModes getInverterModes() {
        return inverterModes;
    }

    public void setInverterModes(InverterModes inverterModes) {
        this.inverterModes = inverterModes;
    }

    public PowerStatus getPower() {
        return power;
    }

    public void setPower(PowerStatus power) {
        this.power = power;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getkWh() {
        return kWh;
    }

    public void setkWh(Integer kWh) {
        this.kWh = kWh;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
