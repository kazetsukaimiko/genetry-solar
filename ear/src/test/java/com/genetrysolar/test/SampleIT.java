package com.genetrysolar.test;

import com.genetrysolar.victor.service.telemetry.TelemetryService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

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
        victim.getEntityById(1L);

        //victim.sendMessage("Favaro");
    }


}
