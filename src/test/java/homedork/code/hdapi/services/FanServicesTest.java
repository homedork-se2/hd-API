package homedork.code.hdapi.services;

import homedork.code.hdapi.model.Fan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FanServicesTest {

	static FanServices fanServices;
	static String failUserId = "999999";
	static String userId = "342212";

	static String failFanId = "99999";
	static String fanId = "34314";
	static double level = 23.0;

	List<Fan> fans;
	// REQ:  used database tables are populated

	@BeforeAll
	void setup() {
		fanServices = new FanServices();
		fans = new ArrayList<>();
	}

	@Test
	void getAllFans() {
		// PASS : getting all fans with actual user ID
		Assertions.assertNotNull(fanServices.getAllFans(userId));

		// PASS : getting all fans with fail user ID
		Assertions.assertEquals(fanServices.getAllFans(failUserId), fans);
	}

	@Test
	void turnFanOff() {
		// PASS : turn off user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.turnFanOff(fanId, userId));

		// PASS : turn off user's(id=failUserId) fan(id=failFanId)
		Assertions.assertNull(fanServices.turnFanOff(failFanId, failUserId));
	}

	@Test
	void turnFanOn() {
		// PASS : turn on user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.turnFanOn(fanId, userId));

		// PASS : turn on user's(id=failUserId) fan(id=failFanId)
		Assertions.assertNull(fanServices.turnFanOn(failFanId, failUserId));
	}

	@Test
	void getFan() {
		// PASS : get user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.getFan(fanId, userId));

		// PASS : get user's(id=fakeUserId) fan(id=fakeFanId)
		Assertions.assertNull(fanServices.getFan(failFanId, failUserId));
	}

	@Test
	void slideFanLevel() {
		// PASS : slide user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.slideFanLevel(fanId, level, userId));

		// PASS : slide user's(id=fakeUserId) fan(id=fakeFanId)
		Assertions.assertNull(fanServices.slideFanLevel(failFanId, level, failUserId));
	}
}