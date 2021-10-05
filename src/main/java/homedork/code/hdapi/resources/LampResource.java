package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Lamp;
import homedork.code.hdapi.services.LampServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


public class LampResource {

	LampServices lampServices = new LampServices();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Lamp> getLamps(@PathParam("userId") String userId) {
		return lampServices.getAllLamps(userId);
	}

	@PUT
	@Path("/{lampId}/turnOff")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lamp turnLampOff(@PathParam("lampId") String lampId, @PathParam("userId") String userId) {
		return lampServices.turnLampOff(lampId, userId);
	}

	@PUT
	@Path("/{lampId}/turnOn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lamp turnLampOn(@PathParam("lampId") String lampId, @PathParam("userId") String userId) {
		return lampServices.turnLampOn(lampId, userId);
	}

	@GET
	@Path("/{lampId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lamp getLamp(@PathParam("lampId") String lampId, @PathParam("userId") String userId) {
		return lampServices.getLamp(lampId, userId);
	}

	@PUT
	@Path("/{lampId}/adjust/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lamp slideLampValue(@PathParam("lampId") String lampId, @PathParam("value") double value, @PathParam("userId") String userId) {
		return lampServices.slideLamp(lampId, value, userId);
	}
}
