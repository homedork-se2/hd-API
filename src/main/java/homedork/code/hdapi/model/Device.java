package homedork.code.hdapi.model;

import java.util.UUID;

public abstract class Device {
	public UUID id;
	public State state;  // "on" and "off" for all device types.
	public DeviceType deviceType;  // "LAMP","FAN" , "THERMOMETER", "CURTAIN" ...
	public UUID userId;
	public double level;  // brightness : Lamp[ceiling + floor] . Speed : Fan . Warmth : Thermometer

	public DeviceType getDeviceType() {
		return deviceType;
	}

	// for some reasons we have this here, but I -@Willz think it will be a time saver soon.
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

	public void setState(State state) {
		this.state = state;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}
}
