package homedork.code.hdapi.services;

import homedork.code.hdapi.model.Device;
import homedork.code.hdapi.model.Lamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LampServicesTest {

	static LampServices lampServices;
	static String failUserId = "999999";
	static String userId = "7IT6aTO2cThiDAOpHshvX9e8z9t1";

	static String failLampId = "99999";
	static String lampId = "34312";
	static double level = 23.0;

	List<Lamp> lamps;

	// REQ:  used database tables are populated

	@BeforeAll
	void setup() {
		lampServices = new LampServices();
		lamps = new ArrayList<>();
	}

	@Test
	void getLamp() {
		// PASS : get user's(id=userId) lamp(id=LampId)
		Assertions.assertNotNull(lampServices.getLamp(lampId));

		// PASS : get user's(id=failUserId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.getLamp(failLampId));
	}

	@Test
	void getAllLamps() {
		// PASS : getting all lamps with actual user ID
		Assertions.assertNotNull(lampServices.getAllLamps(userId));

		// PASS : getting all lamps with fail user ID
		Assertions.assertEquals(lampServices.getAllLamps(failUserId), lamps);
	}

	@Test
	void turnLampOff() {
		// PASS : turn off user's(id=userId) lamp(id=LampId)
		Assertions.assertNotNull(lampServices.turnLampOff(lampId));

		// PASS : turn off user's(id=failUserId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.turnLampOff(failLampId));
	}

	@Test
	void turnLampOn() {
		// PASS : turn off user's(id=userId) lamp(id=LampId)
		Assertions.assertNotNull(lampServices.turnLampOn(lampId));

		// PASS : turn on user's(id=failUserId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.turnLampOn(failLampId));
	}



	@Test
	void slideLampLevel() {
		// PASS : slide user's(id=userId) lamp(id=LampId)
		Assertions.assertNotNull(lampServices.slideLampLevel(lampId, level));

		// PASS : slide user's(id=failUserId) lamp(id=failLampId)
		Assertions.assertNull(lampServices.slideLampLevel(failLampId, level));
	}
}