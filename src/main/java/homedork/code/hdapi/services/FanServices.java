package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.DeviceType;
import homedork.code.hdapi.model.Fan;
import homedork.code.hdapi.model.Window;

import java.io.IOException;
import java.util.List;

public class FanServices {

	QueryBuilder queryBuilder = new QueryBuilder();

	public List<Fan> getAllFans(String userId) {
		try {
			return queryBuilder.getAllDevicesGeneric(userId, DeviceType.FAN);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fan turnFanOff(String fanId) {
		try {
			return queryBuilder.turnDeviceOffGeneric(fanId, DeviceType.FAN);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fan turnFanOn(String fanId) {
		try {
			return queryBuilder.turnDeviceOnGeneric(fanId, DeviceType.FAN);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fan getFan(String fanId) {
		try {
			return queryBuilder.getGenericDevice(fanId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fan slideFanLevel(String fanId, double value) {
		try {
			return queryBuilder.deviceSlideLevelGeneric(value, fanId, DeviceType.FAN);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fan deleteFan(String fanId) {
		try {
			return queryBuilder.deleteGenericDevice(fanId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
