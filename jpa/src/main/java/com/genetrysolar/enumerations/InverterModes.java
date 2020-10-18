package com.genetrysolar.enumerations;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InverterModes {
    POWER_ON("Power On"),
    CHARGER("Charger"),
    INVERTER("Inverter"),
    OFF("Off"),
    ERROR("Error");

    private final String description;

    InverterModes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @JsonValue
    public int getOrdinal() {
        return ordinal();
    }
}
