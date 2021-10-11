package homedork.code.hdapi.model;

import java.util.UUID;

public abstract class Device {
	public UUID id;
	public State state;  // "on" and "off"
	public DeviceType deviceType;  // "LAMP","FAN" ...
	public UUID userId;

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public State getState() {
		return state;
	}

	public void turnOff() {
		this.state = State.OFF;
	}

	public void turnOn() {
		this.state = State.ON;
	}

	public UUID getId() {
		return id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}
}
