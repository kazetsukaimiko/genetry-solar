package com.genetrysolar.victor.entity.telemetry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class TelemetryTest<T> {

    // JSON
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected abstract String getExample();
    protected abstract Class<T> getKlazz();

    protected T victim;

    @Before
    public void init() throws JsonProcessingException {
        victim = OBJECT_MAPPER.readValue(getExample(), getKlazz());
    }

    @Test
    public void ensureJsonParses() {
        Assert.assertNotNull(victim);
    }
}
