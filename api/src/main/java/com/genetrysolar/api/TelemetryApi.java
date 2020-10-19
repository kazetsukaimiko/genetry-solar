package com.genetrysolar.api;

import com.genetrysolar.jpa.AllTelemetry;
import com.genetrysolar.model.RowCount;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path(TelemetryApi.ROOT)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TelemetryApi {
    String INVERTER_ID = "inverter_id";
    String ROOT = "/telemetry";
    String FOR_INVERTER = "/inverter/{" + INVERTER_ID + "}";

    @GET
    default String telemetryRoot() {
        return "Telemetry root";
    }

    @GET
    @Path(FOR_INVERTER)
    List<AllTelemetry> getTelemetryOf(@PathParam(INVERTER_ID) String inverterId);

    @POST
    @Path(FOR_INVERTER)
    AllTelemetry recordTelemetry(@PathParam(INVERTER_ID) String inverterId, AllTelemetry payload);

    // TODO: Remove or secure
    @DELETE
    @Path(FOR_INVERTER)
    RowCount deleteTelemetry(@PathParam(INVERTER_ID) String inverterId);
}
