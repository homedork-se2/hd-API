package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Thermometer;
import homedork.code.hdapi.services.ThermServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/therms")
public class ThermResource {
	ThermServices thermServices = new ThermServices();


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Thermometer> getTherms(@PathParam("userId") String userId) {
		System.out.println("GET user: " + userId + " therms");
		return thermServices.getAllTherms(userId);
	}

	@PUT
	@Path("/{thermId}/turnOff")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Thermometer turnThermOff(@PathParam("thermId") String thermId, @PathParam("userId") String userId) {
		System.out.println("Turn user: " + userId + " therm off");
		return thermServices.turnThermOff(thermId);
	}

	@PUT
	@Path("/{thermId}/turnOn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Thermometer turnThermOn(@PathParam("thermId") String thermId, @PathParam("userId") String userId) {
		System.out.println("Turn user: " + userId + " therm on");
		return thermServices.turnThermOn(thermId);
	}

	@GET
	@Path("/{thermId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Thermometer getTherm(@PathParam("thermId") String thermId, @PathParam("userId") String userId) {
		System.out.println("GET user: " + userId + " therm");
		return thermServices.getTherm(thermId);
	}

	@PUT
	@Path("/{thermId}/adjust/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Thermometer slideThermValue(@PathParam("thermId") String thermId, @PathParam("value") double value, @PathParam("userId") String userId) {
		System.out.println("Slide user: " + userId + " therm to value: " + value);
		return thermServices.slideThermLevel(thermId, value);
	}

}
