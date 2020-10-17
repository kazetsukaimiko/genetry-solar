package com.genetrysolar.victor.service;

import com.genetrysolar.victor.entity.telemetry.AllTelemetry;
import com.genetrysolar.victor.entity.telemetry.TelemetryFragment;
import com.genetrysolar.victor.service.telemetry.TelemetryRecorder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/*
 * Main service for recording telemetry.
 */
@ApplicationScoped
public class TelemetryService implements TelemetryRecorder {
    private static final Logger LOGGER = Logger.getLogger(TelemetryService.class.getName());

    // Really lazy- TODO: Use Infinispan.
    private static final Map<String, AllTelemetry> toBeMerged = new HashMap<>();

    @Inject
    @Any
    private Instance<TelemetryRecorder> recorderInstance;

    @Inject
    private ElasticSearchService elasticSearchService;

    @Override
    public synchronized void record(@Observes @Any TelemetryFragment telemetry) throws IOException {
        if (!toBeMerged.containsKey(telemetry.getSourceId())) {
            toBeMerged.put(telemetry.getSourceId(), new AllTelemetry());
        }
        AllTelemetry allTelemetry = toBeMerged.get(telemetry.getSourceId());
        telemetry.apply(allTelemetry);
        if (allTelemetry.isComplete()) {

            // TODO PERSIST
            toBeMerged.remove(telemetry.getSourceId());
            elasticSearchService.bulkInsert("telemetry", Collections.singletonList(allTelemetry));
        }
    }

    private boolean notTelemetryService(TelemetryRecorder telemetryRecorder) {
        return !(telemetryRecorder instanceof TelemetryService);
    }

}
