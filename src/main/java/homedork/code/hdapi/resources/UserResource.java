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
		System.out.println("GET REQUEST ON USER'S PROFILE");
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
		System.out.println("GET REQUEST ON USER'S DEVICES");
		return userServices.getUserDevices(userId);
	}

	/**
	 * On user click button to add new device,
	 * deviceType is selected and pointed to this API.
	 * Next free pin slot is sent back as a TEXT_PLAIN response.
	 *
	 * <p>
	 * New device added in database.
	 * </p>
	 *
	 * @param userId     - user ID
	 * @param deviceType - DeviceType selected by user
	 * @return - String of pin slot to plug new device.
	 */
	@GET
	@Path("/{userId}/new-device/{deviceType}/")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getPinSlot(@PathParam("userId") String userId, @PathParam("deviceType") String deviceType) {
		System.out.println("NEW DEVICE POSTED");
		System.out.println("GET USER'S FREE PIN AND RETURN");
		return userServices.getPinSLot(userId, deviceType);
	}

	/**
	 * @return added user object
	 */
	@POST
	@Path("/add/{uuid}/{name}/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User addNewUser(@PathParam("uuid") String userId, @PathParam("name") String name, @PathParam("email") String email) {
		System.out.println("NEW USER POSTED");
		User userObject = new User(name, email, userId);
		return userServices.addNewUser(userObject);
	}


	/* ******* User's Devices ************** */

	/**
	 * @return - Fan resource object
	 */
	@Path("/{userId}/fans")
	public FanResource getFanResource() {
		return new FanResource();
	}

	/**
	 * @return - Thermometer resource object
	 */
	@Path("/{userId}/therms")
	public ThermResource getThermResource() {
		return new ThermResource();
	}

	/**
	 * @return - Curtain resource object
	 */
	@Path("/{userId}/curtains")
	public CurtainResource getCurtainResource() {
		return new CurtainResource();
	}

	/**
	 * @return - Lamp resource object
	 */
	@Path("/{userId}/lamps")
	public LampResource getLampResource() {
		return new LampResource();
	}

	/**
	 * @return - Alarm resource object
	 */
	@Path("/{userId}/alarms")
	public AlarmResource getAlarmResource() {
		return new AlarmResource();
	}

	/**
	 * @return - Window resource object
	 */
	@Path("/{userId}/windows")
	public WindowResource getWindowResource() {
		return new WindowResource();
	}


}
