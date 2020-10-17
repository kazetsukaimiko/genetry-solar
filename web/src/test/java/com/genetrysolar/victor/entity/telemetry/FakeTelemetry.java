package com.genetrysolar.victor.entity.telemetry;

import com.genetrysolar.victor.entity.telemetry.enumerations.InverterModes;
import com.genetrysolar.victor.entity.telemetry.enumerations.PowerStatus;
import com.genetrysolar.victor.entity.telemetry.enumerations.TemperatureRadix;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.stream.IntStream;

public class FakeTelemetry {

    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final double MAX_TEMP = 160d;
    private static final double NORMAL_TEMP = 70d;

    public StatusTelemetry makeStatusTelemetry(String sourceId) {
        StatusTelemetry statusTelemetry = new StatusTelemetry();
        statusTelemetry.setHours(2);
        statusTelemetry.setInverterModes(InverterModes.INVERTER);
        statusTelemetry.setkWh(1234);
        statusTelemetry.setPower(PowerStatus.ON);
        statusTelemetry.setVersion("0.0");
        statusTelemetry.setSourceId(sourceId);
        return statusTelemetry;
    }

    public SetupTelemetry makeSetupTelemetry(String sourceId) {
        SetupTelemetry setupTelemetry = new SetupTelemetry();
        //"{\"model\":\"LFPSW-9000-48-220SP\", \"hardver\":0.0, \"UVPa\":41.7, \"UVPe\":39.9, \"OVPa\":58.2, \"OVPe\":60.1, \"ChargeIn\":0}";
        setupTelemetry.setModel("LFPSW-8000-48-220SP");
        setupTelemetry.setHardwareVersion(0.0);
        setupTelemetry.setUvAlarmVoltage(41.7);
        setupTelemetry.setUvErrorVoltage(39.9);
        setupTelemetry.setOvAlarmVoltage(58.2);
        setupTelemetry.setOvErrorVoltage(60.1);
        setupTelemetry.setChargeCapable(0d);
        setupTelemetry.setSourceId(sourceId);
        return setupTelemetry;
    }

    public TemperatureTelemetry makeTempTelemetry(String sourceId, int loadPct) {
        TemperatureTelemetry temperatureTelemetry = new TemperatureTelemetry();
        // 70 - 80 degrees F
        double ambientTemp = randomAround(75d, 5d);
        temperatureTelemetry.setAmbientThermistor(ambientTemp);
        temperatureTelemetry.setCpuThermistor(aboveAmbient(10d, ambientTemp));
        temperatureTelemetry.setTransformerThermistor(randomAround(xformerTempByLoadAndAmbient(loadPct, ambientTemp), 2d));
        // TODO: Other fields, lazy
        temperatureTelemetry.setMosfetThermistor(randomRange(ambientTemp + 10d, ambientTemp + 20d));
        temperatureTelemetry.setRdx(TemperatureRadix.F);
        temperatureTelemetry.setThermistor1(randomAround(ambientTemp + 10d, 3d));
        temperatureTelemetry.setThermistor2(randomAround(ambientTemp + 10d, 3d));
        temperatureTelemetry.setThermistor3(randomAround(ambientTemp + 10d, 3d));
        temperatureTelemetry.setThermistor4(randomAround(ambientTemp + 10d, 3d));
        temperatureTelemetry.setThermistor5(randomAround(ambientTemp + 10d, 3d));
        temperatureTelemetry.setThermistor6(randomAround(ambientTemp + 10d, 3d));
        temperatureTelemetry.setSourceId(sourceId);
        return temperatureTelemetry;
    }

    // Generate a temperature somewhere above ambient.
    public double aboveAmbient(double above, double ambientTemp) {
        return randomAround(ambientTemp + above, above * .25);
    }

    @Test
    public void testTransformerSim() {
        IntStream.range(70, 110)
                //.filter(t -> t == 70 || t == 109)
                .boxed()
                .map(Number::doubleValue)
                .forEach(ambientTemp -> {
                    final boolean[] done = {false};
                    IntStream.range(0, 100)
                            //.filter(at -> at == 0 || at == 99)
                            .forEach(loadPct -> {
                                double xformerTemp = xformerTempByLoadAndAmbient(loadPct, ambientTemp);
                                if (xformerTemp >= MAX_TEMP && !done[0]) {
                                    done[0] = true;
                                    System.out.println("loadPct: " + loadPct + "; ambientTemp: " + ambientTemp + "; result: " + xformerTemp);
                                }
                            });
                });
    }


    // Generate a temperature for thermistor based on load percentage.
    // TODO: Fan speed influence?
    public double xformerTempByLoadAndAmbient(int loadPct, double ambientTemp) {
        double tempSwing = Math.abs(MAX_TEMP - NORMAL_TEMP);
        double ambientMultiplier = ((ambientTemp / NORMAL_TEMP) - 1) * .93;
        double loadMultiplier = (Integer.valueOf(loadPct).doubleValue() / 100d);
        double loadEstimate = loadMultiplier * (tempSwing / 3.2);
        return (loadEstimate + (tempSwing * ambientMultiplier)) + ambientTemp;
    }

    public double randomAround(Double coord, Double swing) {
        return randomRange(coord - swing, coord + swing);
    }

    public double randomRange(Double min, Double max) {
        return new BigDecimal((RANDOM.nextDouble() % (max - min)) + min)
                .setScale(2, RoundingMode.CEILING)
                .doubleValue();
    }
}
