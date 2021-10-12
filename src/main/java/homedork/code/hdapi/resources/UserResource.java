package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Device;
import homedork.code.hdapi.model.User;
import homedork.code.hdapi.services.UserServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserResource {

	UserServices userServices = new UserServices();

	/**
	 * Profile page data
	 *
	 * @param userId user id
	 * @return user object
	 */
	@GET
	@Path("/{userId}/profile")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("userId") String userId) {
		System.out.println("GET REQUEST ON USER");
		System.out.println(userId);
		return userServices.getUser(userId);
	}

	/**
	 * web/android app home page
	 * Display all user devices and states
	 *
	 * @param userId user id
	 * @return list of all user's connected devices
	 */
	@GET
	@Path("/{userId}/devices")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Device> getUserDevices(@PathParam("userId") String userId) {
		return userServices.getUserDevices(userId);
	}


	/**
	 * @return - Fan resource object
	 */
	@Path("/{userId}/fans")
	public FanResource getFanResource() {
		return new FanResource();
	}

	/**
	 * @return - Lamp resource object
	 */
	@Path("/{userId}/lamps")
	public LampResource getLampResource() {
		return new LampResource();
	}
}
