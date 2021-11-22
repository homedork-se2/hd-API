package homedork.code.hdapi.services;

import homedork.code.hdapi.model.Device;
import homedork.code.hdapi.model.DeviceType;
import homedork.code.hdapi.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServicesTest {

	static UserServices userServices;
	static String failUserId = "34221";
	static String userId = "7IT6aTO2cThiDAOpHshvX9e8z9t1";

	// empty devices list for null list test
	List<Device> devices;
	User user;
	DeviceType deviceType;

	// REQ:  used database tables are populated

	@BeforeAll
	void setup() {
		userServices = new UserServices();
		devices = new ArrayList<>();
		user = new User("Test-user1", "test@mail.com", "4IT6aTO2cThiDAOpHshvX9e8z444");
		deviceType = DeviceType.FAN;
	}

	@Test
	void getUser() {
		// PASS : get user(id=userId)
		Assertions.assertNotNull(userServices.getUser(userId));

		// PASS : get user(id=failUserId)
		Assertions.assertNull(userServices.getUser(failUserId));
	}

	@Test
	void getUSerDevices() {
		// PASS : get user's(id=userId) devices(all)
		Assertions.assertNotNull(userServices.getUserDevices(userId));

		// PASS : get user's(id=failUserId) devices(all)
		Assertions.assertEquals(userServices.getUserDevices(failUserId), devices);
	}

	@Test
	void addNewUser() {
		// PASS : add new user
		Assertions.assertNotNull(userServices.addNewUser(user));
	}

	@Test
	void getPinSLot() {
		// PASS : insert new device
		Assertions.assertNotNull(userServices.getPinSLot(userId, deviceType.toString()));
	}
}