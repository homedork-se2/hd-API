package homedork.code.hdapi.model;

import java.util.UUID;

public class Lamp extends Device {
	public double level;    // brightness control

	public Lamp() {
		this.id = UUID.randomUUID();
		this.state = "off";
	}

	public UUID getId() {
		return id;
	}

	public String getState() {
		return state;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}
}
