package com.genetrysolar.seed;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.genetrysolar.api.TelemetryApi;
import com.genetrysolar.client.ClientUtil;
import org.junit.Before;

public abstract class E2ETestBase extends FakeTelemetry {
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);
    protected static final String VICTOR_REST = "http://127.0.0.1:8080/victor/rest";

    protected TelemetryApi telemetryApi;

    @Before
    public void makeClients() {
        telemetryApi = ClientUtil.makeClient(VICTOR_REST, TelemetryApi.class);
    }

}
