package com.genetrysolar.victor.service.telemetry;

import com.genetrysolar.api.AllTelemetryCRUD;
import com.genetrysolar.jpa.AllTelemetry;
import com.genetrysolar.jpa.AllTelemetry_;
import com.genetrysolar.jpa.EntityBase_;
import com.genetrysolar.model.TelemetryFragment;
import com.genetrysolar.victor.Victor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Stream;

/*
 * Main service for recording telemetry.
 */

@ApplicationScoped
public class TelemetryService implements AllTelemetryCRUD, TelemetryRecorder {
    private static final Logger LOGGER = Logger.getLogger(TelemetryService.class.getName());

    // Really lazy- TODO: Use Infinispan.
    private static final Map<String, AllTelemetry> telemetryCache = new HashMap<>();

    public TelemetryService() {
    }

    @PersistenceContext(unitName = Victor.DATASOURCE)
    protected EntityManager entityManager;

    //@Inject
    //private Cache<String, AllTelemetry> telemetryCaches;

    /*
    /*
    @Inject
    @Any
    private Instance<TelemetryRecorder> recorderInstance;
    */

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        System.out.println("Making this class initialize at startup");
    }

    @Override
    public synchronized void record(@Observes @Any TelemetryFragment telemetry) throws IOException {
        AllTelemetry allTelemetry = telemetryCache.computeIfAbsent(telemetry.getSourceId(), this::makeTelemetry);
        telemetry.apply(allTelemetry);
        telemetryCache.put(telemetry.getSourceId(), allTelemetry);
        if (allTelemetry.isComplete()) {
            telemetryCache.remove(telemetry.getSourceId());
            System.out.println("####### ALLTELEMETRY COMPLETED #######");
            persist(allTelemetry);
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

    // CRUD Operations

    @Override
    @Transactional
    public AllTelemetry persist(AllTelemetry entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public int delete(Long entityId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<AllTelemetry> cd = cb.createCriteriaDelete(AllTelemetry.class);
        Root<AllTelemetry> root = cd.from(AllTelemetry.class);
        return entityManager.createQuery(cd.where(cb.equal(root.get(EntityBase_.id), entityId)))
                .executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAll(String sourceId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<AllTelemetry> cd = cb.createCriteriaDelete(AllTelemetry.class);
        Root<AllTelemetry> root = cd.from(AllTelemetry.class);
        return entityManager.createQuery(cd.where(cb.equal(root.get(AllTelemetry_.sourceId), sourceId)))
                .executeUpdate();
    }

    @Override
    public AllTelemetry getEntityById(Long entityId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AllTelemetry> cq = cb.createQuery(AllTelemetry.class);
        Root<AllTelemetry> root = cq.from(AllTelemetry.class);
        return entityManager.createQuery(cq.where(cb.equal(root.get(EntityBase_.id), entityId)))
                .getSingleResult();
    }

    @Override
    public long count() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        return entityManager.createQuery(cq.select(cb.count(cq.from(AllTelemetry.class))))
                .getSingleResult();
    }

    @Override
    public Stream<AllTelemetry> findAllFromSource(String sourceId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AllTelemetry> cq = cb.createQuery(AllTelemetry.class);
        Root<AllTelemetry> root = cq.from(AllTelemetry.class);
        return entityManager.createQuery(cq.where(cb.equal(root.get(AllTelemetry_.sourceId), sourceId)))
                .getResultStream();
    }

}
