package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genetrysolar.jpa.AllTelemetry;

import java.util.Objects;

public class OutputTelemetry extends TelemetryFragment {
    public static final String EXAMPLE = "{\"outV\":236, \"outA\":0.4, \"outW\":91, \"outPF\":0.98, \"outHZ\":0.98}";

    @JsonProperty("outV")
    private Double outputVoltage;
    @JsonProperty("outA")
    private Double outputAmperage;
    @JsonProperty("outW")
    private Double outputWattage;
    @JsonProperty("outPF")
    private Double outPF;
    @JsonProperty("outHZ")
    private Double outHZ;

    public OutputTelemetry() {
    }

    public Double getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(Double outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

    public Double getOutputAmperage() {
        return outputAmperage;
    }

    public void setOutputAmperage(Double outputAmperage) {
        this.outputAmperage = outputAmperage;
    }

    public Double getOutputWattage() {
        return outputWattage;
    }

    public void setOutputWattage(Double outputWattage) {
        this.outputWattage = outputWattage;
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

    @Override
    public String toString() {
        return "OutputTelemetry{" +
                "outputVoltage=" + outputVoltage +
                ", outputAmperage=" + outputAmperage +
                ", outputWattage=" + outputWattage +
                ", outPF=" + outPF +
                ", outHZ=" + outHZ +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputTelemetry that = (OutputTelemetry) o;
        return Objects.equals(outputVoltage, that.outputVoltage) &&
                Objects.equals(outputAmperage, that.outputAmperage) &&
                Objects.equals(outputWattage, that.outputWattage) &&
                Objects.equals(outPF, that.outPF) &&
                Objects.equals(outHZ, that.outHZ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outputVoltage, outputAmperage, outputWattage, outPF, outHZ);
    }

    @Override
    public void apply(AllTelemetry bucket) {
        bucket.setSourceId(getSourceId());
        bucket.setOutputVoltage(getOutputVoltage());
        bucket.setOutputAmperage(getOutputAmperage());
        bucket.setOutputWattage(getOutputWattage());
        bucket.setOutPF(getOutPF());
        bucket.setOutHZ(getOutHZ());
        bucket.setOutputTelemetryCollected(true);
    }
}
