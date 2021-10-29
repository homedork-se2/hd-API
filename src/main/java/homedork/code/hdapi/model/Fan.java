package homedork.code.hdapi.model;

import java.util.UUID;

public class Fan extends Device {

	public Fan(String id) {
		this.id = id;
		this.state = State.OFF;
	}
}
