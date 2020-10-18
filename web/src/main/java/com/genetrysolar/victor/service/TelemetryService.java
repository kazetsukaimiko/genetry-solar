package com.genetrysolar.victor.service;

import com.genetrysolar.jpa.AllTelemetry;
import com.genetrysolar.victor.Victor;
import com.genetrysolar.victor.entity.telemetry.TelemetryFragment;
import com.genetrysolar.victor.service.telemetry.TelemetryRecorder;
import org.infinispan.Cache;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.logging.Logger;

/*
 * Main service for recording telemetry.
 */
@ApplicationScoped
public class TelemetryService implements TelemetryRecorder {
    private static final Logger LOGGER = Logger.getLogger(TelemetryService.class.getName());

    // Really lazy- TODO: Use Infinispan.
    //private static final Map<String, AllTelemetry> toBeMerged = new HashMap<>();


    @PersistenceContext(name = Victor.DEPLOYMENT, unitName = Victor.DEPLOYMENT)
    protected EntityManager entityManager;

    @Inject
    private Cache<String, AllTelemetry> telemetryCache;

    @Inject
    @Any
    private Instance<TelemetryRecorder> recorderInstance;


    @Override
    public synchronized void record(@Observes @Any TelemetryFragment telemetry) throws IOException {
        AllTelemetry allTelemetry = telemetryCache.computeIfAbsent(telemetry.getSourceId(), this::makeTelemetry);
        telemetry.apply(allTelemetry);
        telemetryCache.put(telemetry.getSourceId(), allTelemetry);
        if (allTelemetry.isComplete()) {
            telemetryCache.evict(telemetry.getSourceId());
            entityManager.persist(allTelemetry);
        }
    }

    private AllTelemetry makeTelemetry(String sourceId) {
        AllTelemetry newTelemetry = new AllTelemetry();
        newTelemetry.setSourceId(sourceId);
        return newTelemetry;
    }

    private boolean notTelemetryService(TelemetryRecorder telemetryRecorder) {
        return !(telemetryRecorder instanceof TelemetryService);
    }

}
