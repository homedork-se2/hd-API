package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Device;
import homedork.code.hdapi.model.User;

import java.util.List;

public class UserServices {
	QueryBuilder queryBuilder = new QueryBuilder();

	public User getUser(String userId) {
		return null;
	}

	public List<Device> getUSerDevices(String userId) {
		// get user devices from user where userId = id
		return null;
	}
}
