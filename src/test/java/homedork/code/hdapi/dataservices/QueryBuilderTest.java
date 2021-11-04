package homedork.code.hdapi.dataservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QueryBuilderTest {

	static QueryBuilder queryBuilder;

	static String failUserId = "223d-d342-4f55";
	static String userId = "";

	static String failDeviceId = "223d-d342-4f55";
	static String deviceId = "";
	static double level = 23.0;

	// REQ:  used database tables are populated

	@BeforeAll
	void setup() {
		queryBuilder = new QueryBuilder();
	}

	@Test
	void getUser() throws IOException {
		// PASS : get user(id=userId).
		Assertions.assertNotNull(queryBuilder.getUser(userId));

		Assertions.assertNull(queryBuilder.getUser(failUserId));
	}

	@Test
	void getDevices() throws IOException {
		// PASS : get user's(id=userId) devices(all)
		Assertions.assertNotNull(queryBuilder.getDevices(userId));

		Assertions.assertNull(queryBuilder.getDevices(failUserId));
	}

	@Test
	void getLamps() throws IOException {
		// PASS: turn user's(id=userId) lamps(all).
		Assertions.assertNotNull(queryBuilder.getLamps(userId));

		Assertions.assertNull(queryBuilder.getLamps(failUserId));
	}

	@Test
	void getLamp() throws IOException {
		// PASS: get user's(id=userId) lamp(id=deviceId).
		Assertions.assertNotNull(queryBuilder.getLamp(userId, deviceId));

		Assertions.assertNull(queryBuilder.getLamp(failUserId, failDeviceId));
		Assertions.assertNull(queryBuilder.getLamp(failUserId, deviceId));
		Assertions.assertNull(queryBuilder.getLamp(userId, failDeviceId));
	}

	@Test
	void turnLampOff() throws IOException {
		// PASS: turn user's(id=userId) lamp(id=deviceId) off.
		Assertions.assertNotNull(queryBuilder.turnLampOff(userId, deviceId));

		Assertions.assertNull(queryBuilder.turnLampOff(failUserId, failDeviceId));
		Assertions.assertNull(queryBuilder.turnLampOff(failUserId, deviceId));
		Assertions.assertNull(queryBuilder.turnLampOff(userId, failDeviceId));
	}

	@Test
	void turnLampOn() throws IOException {
		// PASS: turn user's(id=userId) lamp(id=deviceId) on.
		Assertions.assertNotNull(queryBuilder.turnLampOn(userId, deviceId));

		Assertions.assertNull(queryBuilder.turnLampOn(failUserId, failDeviceId));
		Assertions.assertNull(queryBuilder.turnLampOn(failUserId, deviceId));
		Assertions.assertNull(queryBuilder.turnLampOn(userId, failDeviceId));
	}

	@Test
	void slideLampLevel() throws IOException {
		// PASS: slide user's(id=userId) lamp(id=deviceId) to level=level.
		Assertions.assertNotNull(queryBuilder.slideLampLevel(userId, deviceId, level));

		Assertions.assertNull(queryBuilder.slideLampLevel(failUserId, failDeviceId, level));
		Assertions.assertNull(queryBuilder.slideLampLevel(failUserId, deviceId, level));
		Assertions.assertNull(queryBuilder.slideLampLevel(userId, failDeviceId, level));
	}

	@Test
	void getFans() throws IOException {
		// PASS: get user's(id=userId) fans.
		Assertions.assertNotNull(queryBuilder.getFans(userId));

		Assertions.assertNull(queryBuilder.getFans(failUserId));
	}

	@Test
	void getFan() throws IOException {
		// PASS: get user's(id=userId) fan(id=deviceId).
		Assertions.assertNotNull(queryBuilder.getFan(userId, deviceId));

		Assertions.assertNull(queryBuilder.getFan(failUserId, failDeviceId));
		Assertions.assertNull(queryBuilder.getFan(failUserId, deviceId));
		Assertions.assertNull(queryBuilder.getFan(userId, failDeviceId));
	}

	@Test
	void setFanOn() throws IOException {
		// PASS: set user's(id=userId) fan(id=deviceId) on.
		Assertions.assertNotNull(queryBuilder.turnFanOn(userId, deviceId));

		Assertions.assertNull(queryBuilder.turnFanOn(failUserId, failDeviceId));
		Assertions.assertNull(queryBuilder.turnFanOn(failUserId, deviceId));
		Assertions.assertNull(queryBuilder.turnFanOn(userId, failDeviceId));

	}

	@Test
	void turnFanOff() throws IOException {
		// PASS: turn user's(id=userId) fan(id=deviceId) off.
		Assertions.assertNotNull(queryBuilder.turnFanOff(userId, deviceId));

		Assertions.assertNull(queryBuilder.turnFanOff(failUserId, failDeviceId));
		Assertions.assertNull(queryBuilder.turnFanOff(failUserId, deviceId));
		Assertions.assertNull(queryBuilder.turnFanOff(userId, failDeviceId));
	}

	@Test
	void slideFanLevel() throws IOException {
		// PASS: slide user's(id=userId) fan(id=deviceId) to level=level.
		Assertions.assertNotNull(queryBuilder.slideFanLevel(userId, deviceId, level));

		Assertions.assertNull(queryBuilder.slideFanLevel(failUserId, failDeviceId, level));
		Assertions.assertNull(queryBuilder.slideFanLevel(failUserId, deviceId, level));
		Assertions.assertNull(queryBuilder.slideFanLevel(userId, failDeviceId, level));
	}
}