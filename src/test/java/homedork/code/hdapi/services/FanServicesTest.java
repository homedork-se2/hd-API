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
	static String userId = "7IT6aTO2cThiDAOpHshvX9e8z9t1";

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
		Assertions.assertNull(fanServices.getAllFans(failUserId));
	}

	@Test
	void turnFanOff() {
		// PASS : turn off user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.turnFanOff(fanId));

		// PASS : turn off user's(id=failUserId) fan(id=failFanId)
		Assertions.assertNull(fanServices.turnFanOff(failFanId));
	}

	@Test
	void turnFanOn() {
		// PASS : turn on user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.turnFanOn(fanId));

		// PASS : turn on user's(id=failUserId) fan(id=failFanId)
		Assertions.assertNull(fanServices.turnFanOn(failFanId));
	}

	@Test
	void getFan() {
		// PASS : get user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.getFan(fanId));

		// PASS : get user's(id=fakeUserId) fan(id=fakeFanId)
		Assertions.assertNull(fanServices.getFan(failFanId));
	}

	@Test
	void slideFanLevel() {
		// PASS : slide user's(id=userId) fan(id=fanId)
		Assertions.assertNotNull(fanServices.slideFanLevel(fanId, level));

		// PASS : slide user's(id=fakeUserId) fan(id=fakeFanId)
		Assertions.assertNull(fanServices.slideFanLevel(failFanId, level));
	}
}