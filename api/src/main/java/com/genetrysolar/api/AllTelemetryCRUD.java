package com.genetrysolar.api;

import com.genetrysolar.jpa.AllTelemetry;

import java.util.stream.Stream;

public interface AllTelemetryCRUD extends EntityCRUD<AllTelemetry, Long> {
    @Override
    default Long getId(AllTelemetry entity) {
        return entity.getId();
    }

    Stream<AllTelemetry> findAllFromSource(String sourceId);

    int deleteAll(String sourceId);
}
