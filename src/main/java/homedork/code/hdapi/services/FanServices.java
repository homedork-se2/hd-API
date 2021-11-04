package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Fan;

import java.io.IOException;
import java.util.List;

public class FanServices {

	QueryBuilder queryBuilder = new QueryBuilder();

	public List<Fan> getAllFans(String userId) {
		try {
			return queryBuilder.getFans(userId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fan turnFanOff(String fanId, String userId) {
		try {
			return queryBuilder.turnFanOff(userId, fanId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fan turnFanOn(String fanId, String userId) {
		try {
			return queryBuilder.turnFanOn(userId, fanId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fan getFan(String fanId, String userId) {
		try {
			return queryBuilder.getFan(userId, fanId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fan slideFanLevel(String fanId, double value, String userId) {
		try {
			return queryBuilder.slideFanLevel(userId, fanId, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
