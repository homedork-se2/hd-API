package homedork.code.hdapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FanServicesTest {

	static FanServices fanServices;
	static String failUserId = "223d-d342-4f55";
	static String userId = "";

	static String failFanId = "223d-d342-4f55";
	static String fanId = "";
	static double level = 23.0;

	// REQ:  used database tables are populated

	@BeforeAll
	static void setup() {
		fanServices = new FanServices();
	}

	@Test
	void getAllFans() {
		// PASS : getting all fans with actual user ID
		Assertions.assertNotNull(fanServices.getAllFans(userId));

		// PASS : getting all fans with fail user ID
		Assertions.assertNull(fanServices.getAllFans(failUserId));
	}

	@Test
	void turnFanOff() {
		// PASS : turn off user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.turnFanOff(fanId, userId));

		// PASS : turn off user's(id=failUserId) fan(id=failFanId)
		Assertions.assertNull(fanServices.turnFanOff(failFanId, failUserId));
		// PASS : turn off user's(id=failUserId) fan(id=fanId)
		Assertions.assertNull(fanServices.turnFanOff(fanId, failUserId));
		// PASS : turn off user's(id=userId) fan(id=failFanId)
		Assertions.assertNull(fanServices.turnFanOff(failFanId, userId));
	}

	@Test
	void turnFanOn() {
		// PASS : turn on user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.turnFanOn(fanId, userId));

		// PASS : turn on user's(id=failUserId) fan(id=failFanId)
		Assertions.assertNull(fanServices.turnFanOn(failFanId, failUserId));
		// PASS : turn on user's(id=failUserId) fan(id=fanId)
		Assertions.assertNull(fanServices.turnFanOn(fanId, failUserId));
		// PASS : turn on user's(id=userId) fan(id=failFanId)
		Assertions.assertNull(fanServices.turnFanOn(failFanId, userId));
	}

	@Test
	void getFan() {
		// PASS : get user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.getFan(fanId, userId));

		// PASS : get user's(id=fakeUserId) fan(id=fakeFanId)
		Assertions.assertNull(fanServices.getFan(failFanId, failUserId));
		// PASS : get user's(id=fakeUserId) fan(id=fanId)
		Assertions.assertNull(fanServices.getFan(fanId, failUserId));
		// PASS : get user's(id=userId) fan(id=fakeFanId)
		Assertions.assertNull(fanServices.getFan(failFanId, userId));
	}

	@Test
	void slideFanLevel() {
		// PASS : slide user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.slideFanLevel(fanId, level, userId));

		// PASS : slide user's(id=fakeUserId) fan(id=fakeFanId)
		Assertions.assertNull(fanServices.slideFanLevel(failFanId, level, failUserId));
		// PASS : slide user's(id=fakeUserId) fan(id=fanId)
		Assertions.assertNull(fanServices.slideFanLevel(fanId, level, failUserId));
		// PASS : slide user's(id=userId) fan(id=fakeFanId)
		Assertions.assertNull(fanServices.slideFanLevel(failFanId, level, userId));
	}
}