package homedork.code.hdapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ThermServicesTest {

	static ThermServices thermServices;
	static String failUserId = "223d-d342-4f55";
	static String userId = "";

	static String failThermId = "223d-d342-4f55";
	static String thermId = "";
	static double level = 23.0;

	// REQ:  used database tables are populated

	@BeforeAll
	void setUp() {
		thermServices = new ThermServices();
	}

	@Test
	void getAllTherms() {
		// PASS : getting all therms with actual user ID
		Assertions.assertNotNull(thermServices.getAllTherms(userId));

		// PASS : getting all therms with fail user ID
		Assertions.assertNull(thermServices.getAllTherms(failUserId));
	}

	@Test
	void turnThermOff() {
		// PASS : turn off user's(id=userId) therm(id=thermId)
		Assertions.assertNotNull(thermServices.turnThermOff(thermId, userId));

		// PASS : turn off user's(id=failThermId) therm(id=failThermId)
		Assertions.assertNull(thermServices.turnThermOff(failThermId, failUserId));
		// PASS : turn off user's(id=failUserId) therm(id=thermId)
		Assertions.assertNull(thermServices.turnThermOff(thermId, failUserId));
		// PASS : turn off user's(id=userId) therm(id=failThermId)
		Assertions.assertNull(thermServices.turnThermOff(failThermId, userId));
	}

	@Test
	void turnThermOn() {
		// PASS : turn on user's(id=userId) therm(id=thermId)
		Assertions.assertNotNull(thermServices.turnThermOn(thermId, userId));

		// PASS : turn on user's(id=failThermId) therm(id=failThermId)
		Assertions.assertNull(thermServices.turnThermOn(failThermId, failUserId));
		// PASS : turn on user's(id=failUserId) therm(id=thermId)
		Assertions.assertNull(thermServices.turnThermOn(thermId, failUserId));
		// PASS : turn on user's(id=userId) therm(id=failThermId)
		Assertions.assertNull(thermServices.turnThermOn(failThermId, userId));
	}

	@Test
	void getTherm() {
		// PASS : get user's(id=userId) therm(id=thermId)
		Assertions.assertNotNull(thermServices.getTherm(thermId, userId));

		// PASS : get user's(id=failThermId) therm(id=failThermId)
		Assertions.assertNull(thermServices.getTherm(failThermId, failUserId));
		// PASS : get user's(id=failUserId) therm(id=thermId)
		Assertions.assertNull(thermServices.getTherm(thermId, failUserId));
		// PASS : get user's(id=userId) therm(id=failThermId)
		Assertions.assertNull(thermServices.getTherm(failThermId, userId));
	}

	@Test
	void slideThermLevel() {
		// PASS : slide user's(id=userId) therm(id=thermId)
		Assertions.assertNotNull(thermServices.slideThermLevel(thermId, level, userId));

		// PASS : slide user's(id=failThermId) therm(id=failThermId)
		Assertions.assertNull(thermServices.slideThermLevel(failThermId, level, failUserId));
		// PASS : slide user's(id=failUserId) therm(id=thermId)
		Assertions.assertNull(thermServices.slideThermLevel(thermId, level, failUserId));
		// PASS : slide user's(id=userId) therm(id=failThermId)
		Assertions.assertNull(thermServices.slideThermLevel(failThermId, level, userId));
	}
}