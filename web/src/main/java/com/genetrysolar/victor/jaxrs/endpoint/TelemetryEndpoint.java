package com.genetrysolar.victor.jaxrs.endpoint;

import com.genetrysolar.api.TelemetryApi;
import com.genetrysolar.jpa.AllTelemetry;
import com.genetrysolar.model.RowCount;
import com.genetrysolar.victor.service.telemetry.TelemetryService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class TelemetryEndpoint implements TelemetryApi {
    @Inject
    private TelemetryService telemetryService;

    @Override
    public List<AllTelemetry> getTelemetryOf(String inverterId) {
        return telemetryService.findAllFromSource(inverterId)
                .collect(Collectors.toList());
    }

    @Override
    public AllTelemetry recordTelemetry(String inverterId, AllTelemetry payload) {
        payload.setSourceId(inverterId);
        return telemetryService.persist(payload);
    }

    @Override
    public RowCount deleteTelemetry(String inverterId) {
        return new RowCount(telemetryService.deleteAll(inverterId));
    }
}
