package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Lamp;

import java.io.IOException;
import java.util.List;


public class LampServices {
	QueryBuilder queryBuilder = new QueryBuilder();

	public List<Lamp> getAllLamps(String userId) {
		try {
			return queryBuilder.getLamps(userId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Lamp turnLampOff(String lampId, String userId) {
		try {
			 return queryBuilder.turnUserLightOff(userId, lampId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Lamp turnLampOn(String lampId, String userId) {
		return null;
	}

	public Lamp getLamp(String lampId, String userID) {
		return null;
	}

	public Lamp slideLamp(String lampId, double value, String userId) {
		return null;
	}
}
