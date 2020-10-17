package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class FanTelemetry {
    public static final String EXAMPLE = "{\"FA\":14, \"FB\":14, \"FC\":14}";


    @JsonProperty("FA")
    private Integer fanA;

    @JsonProperty("FB")
    private Integer fanB;

    @JsonProperty("FC")
    private Integer fanC;

    public FanTelemetry() {
    }

    public Integer getFanA() {
        return fanA;
    }

    public void setFanA(Integer fanA) {
        this.fanA = fanA;
    }

    public Integer getFanB() {
        return fanB;
    }

    public void setFanB(Integer fanB) {
        this.fanB = fanB;
    }

    public Integer getFanC() {
        return fanC;
    }

    public void setFanC(Integer fanC) {
        this.fanC = fanC;
    }

    @Override
    public String toString() {
        return "FanTelemetry{" +
                "fanA=" + fanA +
                ", fanB=" + fanB +
                ", fanC=" + fanC +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FanTelemetry that = (FanTelemetry) o;
        return Objects.equals(fanA, that.fanA) &&
                Objects.equals(fanB, that.fanB) &&
                Objects.equals(fanC, that.fanC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fanA, fanB, fanC);
    }
}
