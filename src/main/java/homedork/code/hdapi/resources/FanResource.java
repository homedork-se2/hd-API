package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Fan;
import homedork.code.hdapi.services.FanServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/fans")
public class FanResource {

	FanServices fanServices = new FanServices();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Fan> getFans(@PathParam("userId") String userId) {
		System.out.println("GET user: " + userId + " fans");
		return fanServices.getAllFans(userId);
	}

	@PUT
	@Path("/{fanId}/turnOff")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Fan turnFanOff(@PathParam("fanId") String fanId, @PathParam("userId") String userId) {
		System.out.println("Turn user: " + userId + " fan off");
		return fanServices.turnFanOff(fanId);
	}

	@PUT
	@Path("/{fanId}/turnOn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Fan turnFanOn(@PathParam("fanId") String fanId, @PathParam("userId") String userId) {
		System.out.println("Turn user: " + userId + " fan on");
		return fanServices.turnFanOn(fanId);
	}

	@GET
	@Path("/{fanId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Fan getFan(@PathParam("fanId") String fanId, @PathParam("userId") String userId) {
		System.out.println("GET user: " + userId + " fan");
		return fanServices.getFan(fanId);
	}

	@PUT
	@Path("/{fanId}/adjust/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Fan slideFanValue(@PathParam("fanId") String fanId, @PathParam("value") double value, @PathParam("userId") String userId) {
		System.out.println("Slide user: " + userId + " fan to value: " + value);
		return fanServices.slideFanLevel(fanId, value);
	}

}
