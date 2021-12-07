package homedork.code.hdapi.services;

import homedork.code.hdapi.model.Device;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WindowServicesTest {

	static WindowServices windowServices;
	static String failUserId = "999999";
	static String userId = "7IT6aTO2cThiDAOpHshvX9e8z9t1";

	static String failWindowId = "99999";
	static String windowId = "34318";
	static double level = 23.0;

	List<Device> windows;
	// REQ:  used database tables are populated

	@BeforeAll
	void setUp() {
		windowServices = new WindowServices();
		windows = new ArrayList<>();
	}

	@Test
	void getAllWindows() {
		// PASS : getting all windows with actual user ID
		Assertions.assertNotNull(windowServices.getAllWindows(userId));

		// PASS : getting all windows with fail user ID
		Assertions.assertEquals(windowServices.getAllWindows(failUserId), windows);
	}

	@Test
	void closeWindow() {
		// PASS : turn off user's(id=userId) window(id=windowId)
		Assertions.assertNotNull(windowServices.closeWindow(windowId));

		// PASS : turn off user's window(id=failWindowId)
		Assertions.assertNull(windowServices.closeWindow(failWindowId));
	}

	@Test
	void openWindow() {
		// PASS : turn on user's(id=userId) window(id=windowId)
		Assertions.assertNotNull(windowServices.openWindow(windowId));

		// PASS : turn on user's window(id=failWindowId)
		Assertions.assertNull(windowServices.openWindow(failWindowId));
	}

	@Test
	void getWindow() {
		// PASS : get user's(id=userId) window(id=windowId)
		Assertions.assertNotNull(windowServices.getWindow(windowId));

		// PASS : get user's window(id=failWindowId)
		Assertions.assertNull(windowServices.getWindow(failWindowId));
	}

	@Test
	void slideWindowLevel() {
		// PASS : slide user's(id=userId) window(id=windowId)
		Assertions.assertNotNull(windowServices.slideWindowLevel(windowId,level));

		// PASS : slide user's window(id=failWindowId)
		Assertions.assertNull(windowServices.slideWindowLevel(failWindowId,level));
	}
}