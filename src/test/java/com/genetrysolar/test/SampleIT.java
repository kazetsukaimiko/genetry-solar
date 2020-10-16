package com.genetrysolar.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Sample integration test: demonstrates how to create the WAR file using the ShrinkWrap API.
 * 
 * Delete this file if no integration test is required.
 */
@RunWith(Arquillian.class)
public class SampleIT extends ITTestBase {

    /**
     * Creates the WAR file that is deployed to the server.
     *
     * @return WAR archive
     */
    @Deployment
    public static Archive<?> getEarArchive() {
        // Import the web archive that was created by Ma
        return createWar();
    }

    


    /**
     * A sample test...
     * 
     */
    @Test
    public void test() {
        // This line will be written on the server console.
        System.out.println("Test is invoked...");
    }

}
