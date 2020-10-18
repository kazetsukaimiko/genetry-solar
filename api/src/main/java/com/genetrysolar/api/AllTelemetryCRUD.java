package com.genetrysolar.api;

import com.genetrysolar.jpa.AllTelemetry;

public interface AllTelemetryCRUD extends EntityCRUD<AllTelemetry, Long> {
    @Override
    default Long getId(AllTelemetry entity) {
        return entity.getId();
    }
}
