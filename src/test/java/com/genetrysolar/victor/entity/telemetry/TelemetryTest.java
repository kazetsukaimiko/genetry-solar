package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class TelemetryTest<T> {

    // JSON
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    protected static final JsonFactory JSON_FACTORY = OBJECT_MAPPER.getFactory();

    protected abstract String getExample();
    protected abstract Class<T> getKlazz();

    protected T victim;

    @Before
    public void init() throws JsonProcessingException {
        victim = OBJECT_MAPPER.readValue(getExample(), getKlazz());
    }

    @Test
    public void ensureJsonParses() throws IOException {
        Assert.assertNotNull(victim);

        String representation = OBJECT_MAPPER.writeValueAsString(victim);
        T parsedAgain = OBJECT_MAPPER.readValue(representation, getKlazz());
        assertEquals(victim, parsedAgain);

        assertTrue("JSON Produced must match JSON Parsed. \n\nOriginal:\n" +
                        getExample() + "\n\nParsed into:\n" + representation,
                OBJECT_MAPPER.readTree(getExample())
                        .equals(
                                new NumericNodeComparator(),
                                OBJECT_MAPPER.readTree(representation)));
    }

}
