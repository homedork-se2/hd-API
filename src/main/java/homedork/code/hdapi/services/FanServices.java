package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Fan;

import java.util.List;

public class FanServices {

	QueryBuilder queryBuilder = new QueryBuilder();

	public List<Fan> getAllFans(String userId) {
		// query builder method call
		return null;
	}

	public Fan turnFanOff(String fanId, String userId) {
		return null;
	}

	public Fan turnFanOn(String fanId, String userId) {
		return null;
	}

	public Fan getFan(String fanId, String userId) {
		return null;
	}

	public Fan slideFan(String fanId, double value, String userId) {
		// use query builder - query to update fan with id "fanId", return fan obj.
		return null;
	}
}
