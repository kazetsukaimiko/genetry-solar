package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genetrysolar.victor.entity.telemetry.enumerations.ErrorCodes;

public class ErrorTelemetry {
    public static final String EXAMPLE = "{\"Alms\":\"00000000000000000\", \"Err\":0}";

    // TODO : Set<AlarmBits>
    @JsonProperty("Alms")
    private String alarmBits;

    @JsonProperty("Err")
    private ErrorCodes errorCodes;

    public ErrorTelemetry() {
    }

    public String getAlarmBits() {
        return alarmBits;
    }

    public void setAlarmBits(String alarmBits) {
        this.alarmBits = alarmBits;
    }

    public ErrorCodes getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }
}
