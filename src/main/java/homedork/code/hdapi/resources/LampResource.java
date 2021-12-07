package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Alarm;
import homedork.code.hdapi.model.Lamp;
import homedork.code.hdapi.services.LampServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/lamps")
public class LampResource {

    LampServices lampServices = new LampServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Lamp> getLamps(@PathParam("userId") String userId) {
        System.out.println("GET user: " + userId + " lamps");
        return lampServices.getAllLamps(userId);
    }

    @PUT
    @Path("/{lampId}/turnOff")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lamp turnLampOff(@PathParam("lampId") String lampId, @PathParam("userId") String userId) {
        System.out.println("Turn user: " + userId + " lamp off");
        return lampServices.turnLampOff(lampId);
    }

    @PUT
    @Path("/{lampId}/turnOn")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lamp turnLampOn(@PathParam("lampId") String lampId, @PathParam("userId") String userId) {
        System.out.println("Turn user: " + userId + " lamp on");
        return lampServices.turnLampOn(lampId);
    }

    @GET
    @Path("/{lampId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lamp getLamp(@PathParam("lampId") String lampId, @PathParam("userId") String userId) {
        System.out.println("GET user: " + userId + " lamp");
        return lampServices.getLamp(lampId);
    }

    @PUT
    @Path("/{lampId}/adjust/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lamp slideLampValue(@PathParam("lampId") String lampId, @PathParam("value") double value, @PathParam("userId") String userId) {
        System.out.println("Slide user: " + userId + " lamp to value: " + value);
        return lampServices.slideLampLevel(lampId, value);
    }

}
