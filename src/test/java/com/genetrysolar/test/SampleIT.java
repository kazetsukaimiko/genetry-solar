package com.genetrysolar.test;

import com.genetrysolar.victor.service.TelemetryService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Sample integration test: demonstrates how to create the WAR file using the ShrinkWrap API.
 * 
 * Delete this file if no integration test is required.
 */
@RunWith(Arquillian.class)
public class SampleIT extends ITTestBase {


    @Inject
    private TelemetryService telemetryService;

    /**
     * Just testing behavior under different bean scopes
     * 
     */
    @Test
    public void test() {
        // assertEquals(0, telemetryService.inc());
        // assertEquals(1, telemetryService.inc());
    }

}
