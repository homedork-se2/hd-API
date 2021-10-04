package homedork.code.hdapi.model;

import java.util.UUID;

public abstract class Device {
	public UUID id;
	public String state;  // "on" and "off"


	public String getState() {
		return state;
	}

	public void turnOff() {
		this.state = "off";
	}

	public void turnOn() {
		this.state = "on";
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
