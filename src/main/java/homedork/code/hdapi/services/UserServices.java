package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Device;
import homedork.code.hdapi.model.User;

import java.io.IOException;
import java.util.List;

public class UserServices {
	QueryBuilder queryBuilder = new QueryBuilder();

	public User getUser(String userId) {
		try {
			return queryBuilder.getUser(userId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Device> getUserDevices(String userId) {
		try {
			return queryBuilder.getDevices(userId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User addNewUser(User user) {
		try {
			return queryBuilder.addNewUser(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPinSLot(String userId, String deviceType) {
		try {
			return queryBuilder.getFreePin(userId, deviceType);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
