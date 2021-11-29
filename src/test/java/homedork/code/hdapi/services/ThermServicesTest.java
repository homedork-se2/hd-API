package homedork.code.hdapi.services;

import homedork.code.hdapi.model.Thermometer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ThermServicesTest {

	static ThermServices thermServices;
	static String failUserId = "999999";
	static String userId = "7IT6aTO2cThiDAOpHshvX9e8z9t1";

	static String failThermId = "99999";
	static String thermId = "34315";
	static double level = 23.0;

	List<Thermometer> thermometers;

	// REQ:  used database tables are populated

	@BeforeAll
	void setUp() {
		thermServices = new ThermServices();
		thermometers = new ArrayList<>();
	}

	@Test
	void getAllTherms() {
		// PASS : getting all therms with actual user ID
		Assertions.assertNotNull(thermServices.getAllTherms(userId));

		// PASS : getting all therms with fail user ID
		Assertions.assertEquals(thermServices.getAllTherms(failUserId), thermometers);
	}

	@Test
	void turnThermOff() {
		// PASS : turn off user's(id=userId) therm(id=thermId)
		Assertions.assertNotNull(thermServices.turnThermOff(thermId));

		// PASS : turn off user's(id=failThermId) therm(id=failThermId)
		Assertions.assertNull(thermServices.turnThermOff(failThermId));
	}

	@Test
	void turnThermOn() {
		// PASS : turn on user's(id=userId) therm(id=thermId)
		Assertions.assertNotNull(thermServices.turnThermOn(thermId));

		// PASS : turn on user's(id=failThermId) therm(id=failThermId)
		Assertions.assertNull(thermServices.turnThermOn(failThermId));
	}

	@Test
	void getTherm() {
		// PASS : get user's(id=userId) therm(id=thermId)
		Assertions.assertNotNull(thermServices.getTherm(thermId));

		// PASS : get user's(id=failThermId) therm(id=failThermId)
		Assertions.assertNull(thermServices.getTherm(failThermId));
	}

	@Test
	void slideThermLevel() {
		// PASS : slide user's(id=userId) therm(id=thermId)
		Assertions.assertNotNull(thermServices.slideThermLevel(thermId, level));

		// PASS : slide user's(id=failThermId) therm(id=failThermId)
		Assertions.assertNull(thermServices.slideThermLevel(failThermId, level));
	}
}