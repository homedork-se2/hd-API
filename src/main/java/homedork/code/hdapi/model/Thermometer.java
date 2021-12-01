package homedork.code.hdapi.model;

public class Thermometer extends Device {
	public Thermometer(String id) {
		this.id = id;
		this.state = State.OFF;
	}

}
