package com.genetrysolar.test;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ITTestBase {

    public static final String PWD = "PWD";
    public static final String TARGET = "./target/victor.war";

    @Test
    public void testCWD() {
        Path path = buildWARArchiveWithMaven(getMavenPath());
        System.out.println("Archive successfully created: " + path.toString());
    }

    public static Path buildWARArchiveWithMaven(Path mavenPath) {
        try {
            assertTrue("pom.xml must exist",
                    Files.isReadable(Paths.get(mavenPath.toString(), "pom.xml")));
            Process p = new ProcessBuilder("mvn", "clean", "package", "-DskipTests")
                    .directory(mavenPath.toFile())
                    .inheritIO()
                    .start();
            p.waitFor(10, TimeUnit.MINUTES);
            Path target = getTargetPath(mavenPath);
            assertTrue("Target " + target.toString() + " must exist", Files.isReadable(target));
            return target;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail(e.getMessage());
            throw new RuntimeException("Cannot build WAR with Maven", e);
        }
    }

    protected static Path getTargetPath(Path mavenPath) {
        return Paths.get(mavenPath.toString(), TARGET).toAbsolutePath();
    }

    protected static Path getMavenPath() {
        return Paths.get(System.getenv().get(PWD)).toAbsolutePath();
    }

    public static Archive<?> createWar() {
        Path mavenWar = buildWARArchiveWithMaven(getMavenPath());
        // Import the web archive that was created by Maven:

        WebArchive war = ShrinkWrap.create(ZipImporter.class, "victor.war")
                .importFrom(mavenWar.toFile())
                .as(WebArchive.class);

        // Add the package containing the test classes:
        war.addPackage("com.genetrysolar.test");

        // Export the WAR file to examine it in case of problems:
        // war.as(ZipExporter.class).exportTo(new File("c:\\temp\\test.war"), true);

        return war;
    }

}
