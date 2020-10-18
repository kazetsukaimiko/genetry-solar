package com.genetrysolar.victor.cdi.producer;

import com.genetrysolar.victor.qualifier.TelemetryCache;
import org.infinispan.cdi.ConfigureCache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class CacheProvider {
    public static final String TELEMETRY_CACHE = "telemetry_cache";

    @ConfigureCache(TELEMETRY_CACHE)
    @TelemetryCache
    @Produces
    public Configuration oneSecondCacheConfig() {
        return new ConfigurationBuilder()
                .locking()
                .lockAcquisitionTimeout(10, TimeUnit.SECONDS)
                .expiration()
                .lifespan(1, TimeUnit.SECONDS)
                .memory()
                .size(10000)
                .build();
    }

}
