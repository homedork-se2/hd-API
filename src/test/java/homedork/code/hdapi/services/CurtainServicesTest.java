package homedork.code.hdapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CurtainServicesTest {

	static CurtainServices curtainServices;
	static String failUserId = "223d-d342-4f55";
	static String userId = "";

	static String failCurtainId = "223d-d342-4f55";
	static String curtainId = "";
	static double level = 23.0;

	// REQ:  used database tables are populated

	@BeforeAll
	void setUp() {
		curtainServices = new CurtainServices();
	}

	@Test
	void getAllCurtains() {
		// PASS : getting all curtains with actual user ID
		Assertions.assertNotNull(curtainServices.getAllCurtains(userId));

		// PASS : getting all curtains with fail user ID
		Assertions.assertNull(curtainServices.getAllCurtains(failUserId));
	}

	@Test
	void turnCurtainOff() {
		// PASS : turn off user's(id=userId) curtain(id=curtainId)
		Assertions.assertNotNull(curtainServices.turnCurtainOff(curtainId, userId));

		// PASS : turn off user's(id=failUserId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.turnCurtainOff(failCurtainId, failUserId));
		// PASS : turn off user's(id=failUserId) curtain(id=curtainId)
		Assertions.assertNull(curtainServices.turnCurtainOff(curtainId, failUserId));
		// PASS : turn off user's(id=userId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.turnCurtainOff(failCurtainId, userId));
	}

	@Test
	void turnCurtainOn() {
		// PASS : turn on user's(id=userId) curtain(id=curtainId)
		Assertions.assertNotNull(curtainServices.turnCurtainOn(curtainId, userId));

		// PASS : turn on user's(id=failUserId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.turnCurtainOn(failCurtainId, failUserId));
		// PASS : turn on user's(id=failUserId) curtain(id=curtainId)
		Assertions.assertNull(curtainServices.turnCurtainOn(curtainId, failUserId));
		// PASS : turn on user's(id=userId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.turnCurtainOn(failCurtainId, userId));
	}

	@Test
	void getCurtain() {
		// PASS : get user's(id=userId) curtain(id=curtainId)
		Assertions.assertNotNull(curtainServices.getCurtain(curtainId, userId));

		// PASS : get user's(id=failUserId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.getCurtain(failCurtainId, failUserId));
		// PASS : get user's(id=failUserId) curtain(id=curtainId)
		Assertions.assertNull(curtainServices.getCurtain(curtainId, failUserId));
		// PASS : get user's(id=userId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.getCurtain(failCurtainId, userId));
	}

	@Test
	void slideCurtainLevel() {
		// PASS : slide user's(id=userId) curtain(id=curtainId)
		Assertions.assertNotNull(curtainServices.slideCurtainLevel(curtainId, level, userId));

		// PASS : slide user's(id=failUserId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.slideCurtainLevel(failCurtainId, level, failUserId));
		// PASS : slide user's(id=failUserId) curtain(id=curtainId)
		Assertions.assertNull(curtainServices.slideCurtainLevel(curtainId, level, failUserId));
		// PASS : slide user's(id=userId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.slideCurtainLevel(failCurtainId, level, userId));
	}
}