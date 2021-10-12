package homedork.code.hdapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LampServicesTest {

	static LampServices lampServices;
	static String failUserId = "223d-d342-4f55";
	static String userId = "";

	static String failLampId = "223d-d342-4f55";
	static String lampId = "";
	static double level = 23.0;

	// REQ:  used database tables are populated

	@BeforeAll
	void setup() {
		lampServices = new LampServices();
	}

	@Test
	void getAllLamps() {
		// PASS : getting all lamps with actual user ID
		Assertions.assertNotNull(lampServices.getAllLamps(userId));

		// PASS : getting all lamps with fail user ID
		Assertions.assertNull(lampServices.getAllLamps(failUserId));
	}

	@Test
	void turnLampOff() {
		// PASS : turn off user's(id=userId) lamp(id=LampId)
		Assertions.assertNotNull(lampServices.turnLampOff(lampId, userId));

		// PASS : turn off user's(id=failUserId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.turnLampOff(failLampId, failUserId));
		// PASS : turn off user's(id=failUserId) lamp(id=lampId)
		Assertions.assertNull(lampServices.turnLampOff(lampId, failUserId));
		// PASS : turn off user's(id=userId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.turnLampOff(failLampId, userId));
	}

	@Test
	void turnLampOn() {
		// PASS : turn off user's(id=userId) lamp(id=LampId)
		Assertions.assertNotNull(lampServices.turnLampOn(lampId, userId));

		// PASS : turn on user's(id=failUserId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.turnLampOn(failLampId, failUserId));
		// PASS : turn on user's(id=failUserId) lamp(id=lampId)
		Assertions.assertNull(lampServices.turnLampOn(lampId, failUserId));
		// PASS : turn on user's(id=userId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.turnLampOn(failLampId, userId));
	}

	@Test
	void getLamp() {
		// PASS : get user's(id=userId) lamp(id=LampId)
		Assertions.assertNotNull(lampServices.getLamp(lampId, userId));

		// PASS : get user's(id=failUserId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.getLamp(failLampId, failUserId));
		// PASS : get user's(id=failUserId) lamp(id=lampId)
		Assertions.assertNull(lampServices.getLamp(lampId, failUserId));
		// PASS : get user's(id=userId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.getLamp(failLampId, userId));
	}

	@Test
	void slideLampLevel() {
		// PASS : slide user's(id=userId) lamp(id=LampId)
		Assertions.assertNotNull(lampServices.slideLampLevel(lampId, level, userId));

		// PASS : slide user's(id=failUserId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.slideLampLevel(failLampId, level, failUserId));
		// PASS : slide user's(id=failUserId) lamp(id=lampId)
		Assertions.assertNull(lampServices.slideLampLevel(lampId, level, failUserId));
		// PASS : slide user's(id=userId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.slideLampLevel(failLampId, level, userId));
	}
}