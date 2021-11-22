package homedork.code.hdapi.services;

import homedork.code.hdapi.model.Alarm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AlarmServicesTest {
	static AlarmServices alarmServices;
	static String failUserId = "999999";
	static String userId = "7IT6aTO2cThiDAOpHshvX9e8z9t1";

	static String failAlarmId = "99999";
	static String alarmId = "34317";
	static double level = 23.0;

	List<Alarm> alarms;
	// REQ:  used database tables are populated

	@BeforeEach
	void setUp() {
		alarmServices = new AlarmServices();
		alarms = new ArrayList<>();
	}

	@Test
	void getAllAlarms() {
		// PASS : getting all alarm with actual user ID
		Assertions.assertNotNull(alarmServices.getAllAlarms(userId));

		// PASS : getting all alarms with fail user ID
		Assertions.assertNull(alarmServices.getAllAlarms(failUserId));
	}

	@Test
	void turnAlarmOff() {
		// PASS : turn off user's(id=userId) alarm(id=alarmId)
		Assertions.assertNotNull(alarmServices.turnAlarmOff(alarmId));

		// PASS : turn off user's(id=failUserId) alarm(id=failAlarmId)
		Assertions.assertNull(alarmServices.turnAlarmOff(failAlarmId));
	}

	@Test
	void turnAlarmOn() {
		// PASS : turn on user's(id=userId) alarm(id=alarmId)
		Assertions.assertNotNull(alarmServices.turnAlarmOn(alarmId));

		// PASS : turn on user's(id=failUserId) alarm(id=failAlarmId)
		Assertions.assertNull(alarmServices.turnAlarmOn(failAlarmId));
	}

	@Test
	void getAlarm() {
		// PASS : get user's(id=userId) alarm(id=alarmId)
		Assertions.assertNotNull(alarmServices.getAlarm(alarmId));

		// PASS : get user's(id=failUserId) alarm(id=failAlarmId)
		Assertions.assertNull(alarmServices.getAlarm(failAlarmId));
	}

	@Test
	void slideAlarmLevel() {
		// PASS : slide user's(id=userId) alarm(id=alarmId)
		Assertions.assertNotNull(alarmServices.slideAlarmLevel(alarmId, level));

		// PASS : slide user's(id=failUserId) alarm(id=failAlarmId)
		Assertions.assertNull(alarmServices.slideAlarmLevel(failAlarmId, level));
	}
}