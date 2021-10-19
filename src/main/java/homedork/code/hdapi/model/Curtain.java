package homedork.code.hdapi.model;

import java.util.UUID;

public class Curtain extends Device {

	public Curtain() {
		this.id = UUID.randomUUID();
		this.state = State.OFF;
	}
}
