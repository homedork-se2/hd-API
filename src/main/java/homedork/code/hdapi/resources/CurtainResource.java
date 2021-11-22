package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Curtain;
import homedork.code.hdapi.services.CurtainServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/curtains")
public class CurtainResource {

	CurtainServices curtainServices = new CurtainServices();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Curtain> getCurtains(@PathParam("userId") String userId) {
		System.out.println("GET user: " + userId + " curtains");
		return curtainServices.getAllCurtains(userId);
	}

	@PUT
	@Path("/{curtainId}/turnOff")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Curtain turnCurtainOff(@PathParam("curtainId") String curtainId, @PathParam("userId") String userId) {
		System.out.println("Turn user: " + userId + " curtain off");
		return curtainServices.turnCurtainOff(curtainId);
	}

	@PUT
	@Path("/{curtainId}/turnOn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Curtain turnCurtainOn(@PathParam("curtainId") String curtainId, @PathParam("userId") String userId) {
		System.out.println("Turn user: " + userId + " curtain on");
		return curtainServices.turnCurtainOn(curtainId);
	}

	@GET
	@Path("/{curtainId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Curtain getCurtain(@PathParam("curtainId") String curtainId, @PathParam("userId") String userId) {
		System.out.println("GET user: " + userId + " curtain");
		return curtainServices.getCurtain(curtainId);
	}

	@PUT
	@Path("/{curtainId}/adjust/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Curtain slideCurtainValue(@PathParam("curtainId") String curtainId, @PathParam("value") double value, @PathParam("userId") String userId) {
		System.out.println("Slide user: " + userId + " curtain to value: " + value);
		return curtainServices.slideCurtainLevel(curtainId, value);
	}
}
