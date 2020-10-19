package com.genetrysolar.seed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.genetrysolar.jpa.AllTelemetry;
import com.genetrysolar.model.OutputTelemetry;
import com.genetrysolar.model.SetupTelemetry;
import com.genetrysolar.model.StatusTelemetry;
import com.genetrysolar.model.TemperatureTelemetry;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AllTelemetrySeedTest extends E2ETestBase {
    @Test
    public void seedData() {
        final String inverterId = "abc";

        int removed = telemetryApi.deleteTelemetry(inverterId).getAffectedCount();
        System.out.println("Removed " + removed + " records for inverter " + inverterId);

        // Make some seed data
        final int total = 10000;
        List<AllTelemetry> seedData = IntStream.range(0, total)
                .mapToObj(idx -> fakeAllTelemetry(inverterId, idx, total))
                .collect(Collectors.toList());

        // Send it to the REST API

        if (false) {
            return;
        }
        final long[] offset = {0};
        seedData
                .stream()
                .map(allTelemetry -> {
                    // Each telemetry should be off by 1s
                    allTelemetry.setTimestamp(allTelemetry.getTimestamp() + (1000 * (offset[0]++)));
                    return allTelemetry;
                })
                //.peek(this::jsond)
                .forEach(allTelemetry -> telemetryApi.recordTelemetry(inverterId, allTelemetry));

        // Fetch it all
        List<AllTelemetry> responseData = telemetryApi.getTelemetryOf(inverterId);

        assertEquals(seedData.size(), responseData.size());

        seedData.forEach(seeded -> assertTrue(responseData.contains(seeded)));
    }

    public void jsond(Object o) {
        System.out.println(json(o));
    }

    public String json(Object o) {
        try {
            return OBJECT_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail(e.getMessage());
            return null;
        }
    }

    public AllTelemetry fakeAllTelemetry(String sourceId, int idx, int total) {
        AllTelemetry allTelemetry = new AllTelemetry();
        allTelemetry.setSourceId(sourceId);

        int loadPct = idx % 100;
        //Double.valueOf(((double) idx / (double) total) * 25d).intValue() + 25;
        System.out.println(loadPct);

        SetupTelemetry setup = makeSetupTelemetry(sourceId);
        StatusTelemetry status = makeStatusTelemetry(sourceId);
        TemperatureTelemetry temp = makeTempTelemetry(sourceId, idx, total, loadPct);
        OutputTelemetry out = makeOutTelemetry(sourceId, loadPct);


        Stream.of(setup, status, temp, out)
                .forEach(fragment -> fragment.apply(allTelemetry));

        return allTelemetry;
    }

}
