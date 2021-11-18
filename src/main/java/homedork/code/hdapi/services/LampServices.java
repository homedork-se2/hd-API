package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.DeviceType;
import homedork.code.hdapi.model.Lamp;

import java.io.IOException;
import java.util.List;


public class LampServices {
	QueryBuilder queryBuilder = new QueryBuilder();

	public List<Lamp> getAllLamps(String userId) {
		try {
			return queryBuilder.getAllDevicesGeneric(userId, DeviceType.LAMP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Lamp turnLampOff(String lampId) {
		try {
			 return queryBuilder.turnDeviceOffGeneric(lampId, DeviceType.LAMP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Lamp turnLampOn(String lampId) {
		try {
			return queryBuilder.turnDeviceOnGeneric(lampId, DeviceType.LAMP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Lamp getLamp(String lampId) {
		try {
			return queryBuilder.getGenericDevice(lampId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Lamp slideLampLevel(String lampId, double value) {
		try {
			return queryBuilder.deviceSlideLevelGeneric(value, lampId, DeviceType.LAMP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
