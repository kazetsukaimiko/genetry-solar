package com.genetrysolar.wifiboard.entity;

import java.math.BigDecimal;

/**
 * Assuming Telemetry is a key-value payload with multiple k/v pairs for now
 */
public class Telemetry {
    // TODO: kaze.math Percentage
    private int loadPercentage;

    // TODO: kaze.math Current
    private BigDecimal loadAmperage;

    // TODO: kaze.math Potential
    private BigDecimal l1Volts;
    private BigDecimal l2Volts;

    // Temp probes
    // TODO: kaze.math Temperature
    private BigDecimal temp1;
    private BigDecimal temp2;
    private BigDecimal temp3;
    private BigDecimal temp4;
    private BigDecimal temp5;

    // Fans
    // TODO: kaze.math RPM
    private BigDecimal fan1;
    private BigDecimal fan2;
    private BigDecimal fan3;

    public int getLoadPercentage() {
        return loadPercentage;
    }

    public void setLoadPercentage(int loadPercentage) {
        this.loadPercentage = loadPercentage;
    }

    public BigDecimal getLoadAmperage() {
        return loadAmperage;
    }

    public void setLoadAmperage(BigDecimal loadAmperage) {
        this.loadAmperage = loadAmperage;
    }

    public BigDecimal getL1Volts() {
        return l1Volts;
    }

    public void setL1Volts(BigDecimal l1Volts) {
        this.l1Volts = l1Volts;
    }

    public BigDecimal getL2Volts() {
        return l2Volts;
    }

    public void setL2Volts(BigDecimal l2Volts) {
        this.l2Volts = l2Volts;
    }

    public BigDecimal getTemp1() {
        return temp1;
    }

    public void setTemp1(BigDecimal temp1) {
        this.temp1 = temp1;
    }

    public BigDecimal getTemp2() {
        return temp2;
    }

    public void setTemp2(BigDecimal temp2) {
        this.temp2 = temp2;
    }

    public BigDecimal getTemp3() {
        return temp3;
    }

    public void setTemp3(BigDecimal temp3) {
        this.temp3 = temp3;
    }

    public BigDecimal getTemp4() {
        return temp4;
    }

    public void setTemp4(BigDecimal temp4) {
        this.temp4 = temp4;
    }

    public BigDecimal getTemp5() {
        return temp5;
    }

    public void setTemp5(BigDecimal temp5) {
        this.temp5 = temp5;
    }

    public BigDecimal getFan1() {
        return fan1;
    }

    public void setFan1(BigDecimal fan1) {
        this.fan1 = fan1;
    }

    public BigDecimal getFan2() {
        return fan2;
    }

    public void setFan2(BigDecimal fan2) {
        this.fan2 = fan2;
    }

    public BigDecimal getFan3() {
        return fan3;
    }

    public void setFan3(BigDecimal fan3) {
        this.fan3 = fan3;
    }
}
