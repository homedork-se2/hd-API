package homedork.code.hdapi.model;

import java.util.UUID;

public class Lamp extends Device {

	public Lamp() {
		this.id = UUID.randomUUID();
		this.state = State.OFF;
	}
}
