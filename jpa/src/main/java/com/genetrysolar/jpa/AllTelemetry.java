package com.genetrysolar.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genetrysolar.enumerations.ErrorCodes;
import com.genetrysolar.enumerations.InverterModes;
import com.genetrysolar.enumerations.PowerStatus;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.Instant;

@Table(
        indexes = {
                @Index(columnList = "ID"),
                @Index(columnList = "SOURCEID")
        }
)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AllTelemetry extends EntityBase {
    private boolean errorTelemetryCollected = true;
    private boolean fanTelemetryCollected = true;
    private boolean inputTelemetryCollected = true;
    private boolean outputTelemetryCollected = true;
    private boolean statusTelemetryCollected = false;
    private boolean tempTelemetryCollected = false;
    private boolean setupTelemetryCollected = false;

    private long timestamp = Instant.now().toEpochMilli();
    private String sourceId;

    // TODO : Set<AlarmBits>
    @JsonProperty("Alms")
    private String alarmBits;

    @JsonProperty("Err")
    private ErrorCodes errorCodes;

    @JsonProperty("FA")
    private Integer fanA;

    @JsonProperty("FB")
    private Integer fanB;

    @JsonProperty("FC")
    private Integer fanC;

    @JsonProperty("ACin")
    private Double acInput;

    @JsonProperty("ChrgA")
    private Double chargeAmperage;

    @JsonProperty("BattV")
    private Double batteryVoltage;

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

    public AllTelemetry() {
    }

    public boolean isErrorTelemetryCollected() {
        return errorTelemetryCollected;
    }

    public void setErrorTelemetryCollected(boolean errorTelemetryCollected) {
        this.errorTelemetryCollected = errorTelemetryCollected;
    }

    public boolean isFanTelemetryCollected() {
        return fanTelemetryCollected;
    }

    public void setFanTelemetryCollected(boolean fanTelemetryCollected) {
        this.fanTelemetryCollected = fanTelemetryCollected;
    }

    public boolean isInputTelemetryCollected() {
        return inputTelemetryCollected;
    }

    public void setInputTelemetryCollected(boolean inputTelemetryCollected) {
        this.inputTelemetryCollected = inputTelemetryCollected;
    }

    public boolean isOutputTelemetryCollected() {
        return outputTelemetryCollected;
    }

    public void setOutputTelemetryCollected(boolean outputTelemetryCollected) {
        this.outputTelemetryCollected = outputTelemetryCollected;
    }

    public boolean isStatusTelemetryCollected() {
        return statusTelemetryCollected;
    }

    public void setStatusTelemetryCollected(boolean statusTelemetryCollected) {
        this.statusTelemetryCollected = statusTelemetryCollected;
    }

    public boolean isTempTelemetryCollected() {
        return tempTelemetryCollected;
    }

    public void setTempTelemetryCollected(boolean tempTelemetryCollected) {
        this.tempTelemetryCollected = tempTelemetryCollected;
    }

    public boolean isSetupTelemetryCollected() {
        return setupTelemetryCollected;
    }

    public void setSetupTelemetryCollected(boolean setupTelemetryCollected) {
        this.setupTelemetryCollected = setupTelemetryCollected;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
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

    public Double getAcInput() {
        return acInput;
    }

    public void setAcInput(Double acInput) {
        this.acInput = acInput;
    }

    public Double getChargeAmperage() {
        return chargeAmperage;
    }

    public void setChargeAmperage(Double chargeAmperage) {
        this.chargeAmperage = chargeAmperage;
    }

    public Double getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Double batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
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

    public boolean isComplete() {
        return isSetupTelemetryCollected()
                && isErrorTelemetryCollected()
                && isFanTelemetryCollected()
                && isInputTelemetryCollected()
                && isOutputTelemetryCollected()
                && isStatusTelemetryCollected()
                && isTempTelemetryCollected();
    }
}
