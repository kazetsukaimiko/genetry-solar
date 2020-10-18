package com.genetrysolar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genetrysolar.enumerations.ErrorCodes;
import com.genetrysolar.jpa.AllTelemetry;

import java.util.Objects;

public class ErrorTelemetry extends TelemetryFragment {
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

    @Override
    public String toString() {
        return "ErrorTelemetry{" +
                "alarmBits='" + alarmBits + '\'' +
                ", errorCodes=" + errorCodes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorTelemetry that = (ErrorTelemetry) o;
        return Objects.equals(alarmBits, that.alarmBits) &&
                errorCodes == that.errorCodes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alarmBits, errorCodes);
    }

    @Override
    public void apply(AllTelemetry bucket) {
        bucket.setSourceId(getSourceId());
        bucket.setAlarmBits(getAlarmBits());
        bucket.setErrorCodes(getErrorCodes());
        bucket.setErrorTelemetryCollected(true);
    }
}
