package com.genetrysolar.victor.entity.telemetry;

public class OutputTelemetry {
    public static final String EXAMPLE = "{\"outV\":236, \"outA\":0.4, \"outW\":91, \"outPF\":0.98, \"outHZ\":0.98}";

    private Double outV;
    private Double outA;
    private Double outW;
    private Double outPF;
    private Double outHZ;

    public OutputTelemetry() {
    }

    public Double getOutV() {
        return outV;
    }

    public void setOutV(Double outV) {
        this.outV = outV;
    }

    public Double getOutA() {
        return outA;
    }

    public void setOutA(Double outA) {
        this.outA = outA;
    }

    public Double getOutW() {
        return outW;
    }

    public void setOutW(Double outW) {
        this.outW = outW;
    }

    public Double getOutPF() {
        return outPF;
    }

    public void setOutPF(Double outPF) {
        this.outPF = outPF;
    }

    public Double getOutHZ() {
        return outHZ;
    }

    public void setOutHZ(Double outHZ) {
        this.outHZ = outHZ;
    }
}
