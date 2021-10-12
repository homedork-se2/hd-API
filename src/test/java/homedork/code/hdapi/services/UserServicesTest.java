package homedork.code.hdapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServicesTest {

	static UserServices userServices;
	static String failUserId = "223d-d342-4f55";
	static String userId = "";

	// REQ:  used database tables are populated

	@BeforeAll
	void setup() {
		userServices = new UserServices();
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
		Assertions.assertNull(userServices.getUserDevices(failUserId));
	}
}