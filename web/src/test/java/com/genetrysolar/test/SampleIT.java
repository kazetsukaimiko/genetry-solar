package com.genetrysolar.test;

import com.genetrysolar.victor.service.telemetry.TelemetryService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.UUID;

/**
 * Sample integration test: demonstrates how to create the WAR file using the ShrinkWrap API.
 * <p>
 * Delete this file if no integration test is required.
 */
@RunWith(Arquillian.class)
public class SampleIT extends ITTestBase {


    @Inject
    private TelemetryService victim;

    /**
     * Just testing behavior under different bean scopes
     */
    @Test
    public void sendMockTelemetry() {
        final String sourceId = UUID.randomUUID().toString();

        //victim.sendMessage("Favaro");
    }


}
