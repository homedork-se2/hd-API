package homedork.code.hdapi.model;

import java.util.UUID;

public class Fan extends Device {

	public Fan() {
		this.id = UUID.randomUUID();
		this.state = State.OFF;
	}
}
