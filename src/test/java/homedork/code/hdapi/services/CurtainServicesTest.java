package homedork.code.hdapi.services;

import homedork.code.hdapi.model.Curtain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CurtainServicesTest {

	static CurtainServices curtainServices;
	static String failUserId = "999999";
	static String userId = "7IT6aTO2cThiDAOpHshvX9e8z9t1";

	static String failCurtainId = "99999";
	static String curtainId = "34316";
	static double level = 23.0;

	List<Curtain> curtains;

	// REQ:  used database tables are populated

	@BeforeAll
	void setUp() {
		curtainServices = new CurtainServices();
		curtains = new ArrayList<>();
	}

	@Test
	void getAllCurtains() {
		// PASS : getting all curtains with actual user ID
		Assertions.assertNotNull(curtainServices.getAllCurtains(userId));

		// PASS : getting all curtains with fail user ID
		Assertions.assertEquals(curtainServices.getAllCurtains(failUserId), curtains);
	}

	@Test
	void turnCurtainOff() {
		// PASS : turn off user's(id=userId) curtain(id=curtainId)
		Assertions.assertNotNull(curtainServices.turnCurtainOff(curtainId));

		// PASS : turn off user's(id=failUserId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.turnCurtainOff(failCurtainId));
	}

	@Test
	void turnCurtainOn() {
		// PASS : turn on user's(id=userId) curtain(id=curtainId)
		Assertions.assertNotNull(curtainServices.turnCurtainOn(curtainId));

		// PASS : turn on user's(id=failUserId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.turnCurtainOn(failCurtainId));
	}

	@Test
	void getCurtain() {
		// PASS : get user's(id=userId) curtain(id=curtainId)
		Assertions.assertNotNull(curtainServices.getCurtain(curtainId));

		// PASS : get user's(id=failUserId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.getCurtain(failCurtainId));
	}

	@Test
	void slideCurtainLevel() {
		// PASS : slide user's(id=userId) curtain(id=curtainId)
		Assertions.assertNotNull(curtainServices.slideCurtainLevel(curtainId, level));

		// PASS : slide user's(id=failUserId) curtain(id=failCurtainId)
		Assertions.assertNull(curtainServices.slideCurtainLevel(failCurtainId, level));
	}
}