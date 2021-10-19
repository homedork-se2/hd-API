package homedork.code.hdapi.model;

import java.util.UUID;

public class Thermometer extends Device {


	public Thermometer() {
		this.id = UUID.randomUUID();
		this.state = State.OFF;
	}

}
