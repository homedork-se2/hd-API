package homedork.code.hdapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
	public String name;
	public String email;
	public UUID id;
	public List<Device> userDevices;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
		this.id = UUID.randomUUID();
		this.userDevices = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UUID getId() {
		return id;
	}


	public List<Device> getUserDevices() {
		return userDevices;
	}

	// add a new device to user catalog
	public void addNewDevice(Device device) {
		this.userDevices.add(device);
	}
}
