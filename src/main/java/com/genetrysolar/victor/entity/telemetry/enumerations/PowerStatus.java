package com.genetrysolar.victor.entity.telemetry.enumerations;

public enum PowerStatus {
    OFF("Off"),
    ON("On"),
    POWER_SAVE("Power Save"),
    SWITCH("Switch"),
    ;

    private final String description;

    PowerStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
