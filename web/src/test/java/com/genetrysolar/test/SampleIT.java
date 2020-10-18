package com.genetrysolar.test;

import com.genetrysolar.model.SetupTelemetry;
import com.genetrysolar.model.StatusTelemetry;
import com.genetrysolar.model.TemperatureTelemetry;
import com.genetrysolar.victor.service.telemetry.TelemetryService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * Sample integration test: demonstrates how to create the WAR file using the ShrinkWrap API.
 * <p>
 * Delete this file if no integration test is required.
 */
@RunWith(Arquillian.class)
public class SampleIT extends ITTestBase {


    @Inject
    private Instance<TelemetryService> victim;

    /**
     * Just testing behavior under different bean scopes
     */
    @Test
    public void sendMockTelemetry() {
        final String sourceId = UUID.randomUUID().toString();

        IntStream.range(0, 1000)
                .forEach(idx -> {
                    SetupTelemetry setup = makeSetupTelemetry(sourceId);
                    StatusTelemetry status = makeStatusTelemetry(sourceId);
                    TemperatureTelemetry temp = makeTempTelemetry(sourceId, ((idx / 1000) * 25) + 25);

                    TelemetryService svc = victim.get();
                    /*
                    try {
                        victim.record(setup);
                        victim.record(status);
                        victim.record(temp);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }*/

                });

        //victim.sendMessage("Favaro");
    }


}
