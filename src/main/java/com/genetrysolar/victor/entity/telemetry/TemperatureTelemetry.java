package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genetrysolar.victor.entity.telemetry.enumerations.TemperatureRadix;

public class TemperatureTelemetry {
    public static final String EXAMPLE = "{\"rdx\":\"F\",\"T1\":106.0, \"T2\":-0.1, \"T3\":100.3, \"T4\":86.4, \"T5\":-0.1, \"T6\":-0.1, \"TT\":95.8, \"TM\":108.5, \"TC\":-0.1, \"TA\":67.1}";

    private TemperatureRadix rdx;

    // Thermistor 1
    @JsonProperty("T1")
    private Double thermistor1;

    // Thermistor 2
    @JsonProperty("T2")
    private Double thermistor2;

    // Thermistor 3
    @JsonProperty("T3")
    private Double thermistor3;

    // Thermistor 4
    @JsonProperty("T4")
    private Double thermistor4;

    // Thermistor 5
    @JsonProperty("T5")
    private Double thermistor5;

    // Thermistor 6
    @JsonProperty("T6")
    private Double thermistor6;

    // transformer thermistor
    @JsonProperty("TT")
    private Double transformerThermistor;

    // MOSFET thermistor
    @JsonProperty("TM")
    private Double mosfetThermistor;

    // CPU temperature
    @JsonProperty("TC")
    private Double cpuThermistor;

    // WiFi board ambient temperature
    @JsonProperty("TA")
    private Double ambientThermistor;

    public TemperatureTelemetry() {
    }

    public TemperatureRadix getRdx() {
        return rdx;
    }

    public void setRdx(TemperatureRadix rdx) {
        this.rdx = rdx;
    }

    public Double getThermistor1() {
        return thermistor1;
    }

    public void setThermistor1(Double thermistor1) {
        this.thermistor1 = thermistor1;
    }

    public Double getThermistor2() {
        return thermistor2;
    }

    public void setThermistor2(Double thermistor2) {
        this.thermistor2 = thermistor2;
    }

    public Double getThermistor3() {
        return thermistor3;
    }

    public void setThermistor3(Double thermistor3) {
        this.thermistor3 = thermistor3;
    }

    public Double getThermistor4() {
        return thermistor4;
    }

    public void setThermistor4(Double thermistor4) {
        this.thermistor4 = thermistor4;
    }

    public Double getThermistor5() {
        return thermistor5;
    }

    public void setThermistor5(Double thermistor5) {
        this.thermistor5 = thermistor5;
    }

    public Double getThermistor6() {
        return thermistor6;
    }

    public void setThermistor6(Double thermistor6) {
        this.thermistor6 = thermistor6;
    }

    public Double getTransformerThermistor() {
        return transformerThermistor;
    }

    public void setTransformerThermistor(Double transformerThermistor) {
        this.transformerThermistor = transformerThermistor;
    }

    public Double getMosfetThermistor() {
        return mosfetThermistor;
    }

    public void setMosfetThermistor(Double mosfetThermistor) {
        this.mosfetThermistor = mosfetThermistor;
    }

    public Double getCpuThermistor() {
        return cpuThermistor;
    }

    public void setCpuThermistor(Double cpuThermistor) {
        this.cpuThermistor = cpuThermistor;
    }

    public Double getAmbientThermistor() {
        return ambientThermistor;
    }

    public void setAmbientThermistor(Double ambientThermistor) {
        this.ambientThermistor = ambientThermistor;
    }
}
