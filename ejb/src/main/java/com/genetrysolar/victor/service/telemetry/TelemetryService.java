package com.genetrysolar.victor.service.telemetry;

import com.genetrysolar.jpa.AllTelemetry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/*
 * Main service for recording telemetry.
 */
@ApplicationScoped
public class TelemetryService { // implements AllTelemetryCRUD { // TelemetryRecorder {
    private static final Logger LOGGER = Logger.getLogger(TelemetryService.class.getName());

    // Really lazy- TODO: Use Infinispan.
    private static final Map<String, AllTelemetry> telemetryCache = new HashMap<>();

    public TelemetryService() {
    }

    //@PersistenceContext(name = Victor.DATASOURCE, unitName = Victor.DATASOURCE)
    //protected EntityManager entityManager;

    //@Inject
    //@TelemetryCache
    //private Cache<String, AllTelemetry> telemetryCaches;

    /*
    @Inject
    @Any
    private Instance<TelemetryRecorder> recorderInstance;
*/

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        System.out.println("Making this class initialize at startup");
    }

    /*
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
    }*/

    private AllTelemetry makeTelemetry(String sourceId) {
        AllTelemetry newTelemetry = new AllTelemetry();
        newTelemetry.setSourceId(sourceId);
        return newTelemetry;
    }

    private boolean notTelemetryService(TelemetryRecorder telemetryRecorder) {
        return !(telemetryRecorder instanceof TelemetryService);
    }

    // CRUD Operations

    //@Override
    public AllTelemetry persist(AllTelemetry entity) {
        //entityManager.persist(entity);
        return entity;
    }

    //@Override
    public int delete(Long entityId) {
        /*
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<AllTelemetry> cd = cb.createCriteriaDelete(AllTelemetry.class);
        Root<AllTelemetry> root = cd.from(AllTelemetry.class);
        return entityManager.createQuery(cd.where(cb.equal(root.get(EntityBase_.id), entityId)))
                .executeUpdate();

         */
        return 0;
    }

    //@Override
    public AllTelemetry getEntityById(Long entityId) {
        /*
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AllTelemetry> cd = cb.createQuery(AllTelemetry.class);
        Root<AllTelemetry> root = cd.from(AllTelemetry.class);
        return entityManager.createQuery(cd.where(cb.equal(root.get(EntityBase_.id), entityId)))
                .getSingleResult();

         */
        return null;
    }
}
