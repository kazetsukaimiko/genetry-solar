package com.genetrysolar.test;

import com.genetrysolar.victor.entity.telemetry.FakeTelemetry;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ITTestBase extends FakeTelemetry {

    public static final String JBOSS_HOME = "jboss.home";
    public static final String USER_HOME = "user.home";


    public static Path getWildflyHome() {
        String jbossHome = System.getProperty(JBOSS_HOME);
        return (jbossHome != null
                ? Paths.get(jbossHome)
                : Paths.get(System.getProperty(USER_HOME), "bin", "wildfly", "gsbase"))
                .normalize()
                .toAbsolutePath();
    }

    public static Archive<?> createWar() {
        System.setProperty("jboss.home", getWildflyHome().toString());

        WebArchive war = ShrinkWrap.create(WebArchive.class, "victor.war");

        // Add any dependencies
        war.addAsResource("arquillian.xml");
        war.addPackages(true, "com.genetrysolar");

        war.addPackages(true, "liquibase");
        war.addPackages(true, "org.infinispan");
        war.addPackages(true, "org.elasticsearch");
        war.addPackages(true, "org.apache.lucene");
        war.addPackages(true, "org.apache.http");
        war.addPackages(true, "org.jboss.weld");

        // Export the WAR file to examine it in case of problems:
        // war.as(ZipExporter.class).exportTo(new File("c:\\temp\\test.war"), true);

        return war;
    }

    /**
     * Creates the WAR file that is deployed to the server.
     *
     * @return WAR archive
     */
    @Deployment
    public static Archive<?> getWarArchive() {
        // Import the web archive that was created by Ma
        return createWar();
    }

}
