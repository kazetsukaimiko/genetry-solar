package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class TelemetryTest<T extends TelemetryFragment> {

    // JSON
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected abstract String getExample();

    protected abstract Class<T> getKlazz();

    protected T victim;

    @Before
    public void init() throws JsonProcessingException {
        victim = OBJECT_MAPPER.readValue(getExample(), getKlazz());
    }

    /**
     * Make sure our example JSON creates the representing object correctly.
     *
     * @throws IOException If there is a problem creating the JSON string from or reading it back into Object representation.
     */
    @Test
    public void testInputJSONUnmarshalls() throws IOException {
        Assert.assertNotNull(victim);

        String representation = OBJECT_MAPPER.writeValueAsString(victim);
        T parsedAgain = OBJECT_MAPPER.readValue(representation, getKlazz());
        assertEquals(victim, parsedAgain);
    }

    /**
     * Make sure JSON we create from these objects matches exactly the sample schema.
     * NumericNodeComparator used to disregard the difference between "val": 5 and "val": 5.0
     *
     * @throws IOException If there is a problem creating JSON String from the Object representation.
     */
    @Test
    public void testOutputJSONIsIdentical() throws IOException {
        Assert.assertNotNull(victim);
        String representation = OBJECT_MAPPER.writeValueAsString(victim);
        assertTrue("JSON Produced must match JSON Parsed. \n\nOriginal:\n" +
                        getExample() + "\n\nParsed into:\n" + representation,
                OBJECT_MAPPER.readTree(getExample())
                        .equals(
                                new NumericNodeComparator(),
                                OBJECT_MAPPER.readTree(representation)));
    }


}
