package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Fan;
import homedork.code.hdapi.model.Lamp;

import java.util.List;


public class LampServices {
	QueryBuilder queryBuilder = new QueryBuilder();

	public List<Lamp> getAllLamps(String userId) {
		return null;
	}

	public Fan turnLampOff(String lampId, String userId) {
		return null;
	}

	public Fan turnLampOn(String lampId, String userId) {
		return null;
	}

	public Fan getLamp(String lampId, String userID) {
		return null;
	}

	public Fan slideLamp(String lampId, double value, String userId) {
		return null;
	}
}
