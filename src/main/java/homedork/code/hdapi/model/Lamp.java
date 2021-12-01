package homedork.code.hdapi.model;

public class Lamp extends Device {

	public Lamp(String id) {
		this.id = id;
		this.state = State.OFF;
	}
}
