package homedork.code.hdapi.dataservices;

import homedork.code.hdapi.comm.Client;
import homedork.code.hdapi.model.*;
import homedork.code.hdapi.utility.JsonJavaParser;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class QueryBuilder {
	/**
	 * Devices table for all devices[floorLamp,ceilingLamp,fan] - nullables for type don't share a particular attribute.
	 * basically devices table is always updated/read through here, alongside users table for user based edits,
	 * when info is needed on user frontend - fetch the latest update from devices/users table
	 */

	Client client = new Client();

	// Generic Queries -------------------------------------------------------------------------------------------
	private List<Device> jsonUserDevicesHandler(String query) throws IOException {
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse();
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toDeviceObjects(jsonArray);
		}
		return null;
	}

	// User Queries ------------------------------------------------------------------------------------------

	private User jsonUserHandler(String query) throws IOException {
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonObject = client.getResponse();
			if(jsonObject == null)
				return null;
			return JsonJavaParser.toUserObject(jsonObject);
		}
		return null;
	}

	public User getUser(String userId) throws IOException {
		String query = String.format("SELECT * from users WHERE id='%s';", userId);
		return jsonUserHandler(query);
	}

	public List<Device> getDevices(String userId) throws IOException {
		String query = String.format("SELECT * from devices WHERE user_id='%s';", userId);
		return jsonUserDevicesHandler(query);
	}

	public User addNewUser(@NotNull User user) throws IOException {
		// INSERT INTO `users` (`id`, `name`, `email`) VALUES ('dada', 'dada', 'dada');
		String q = String.format("INSERT INTO `users` (`id`, `name`, `email`) VALUES ('%s', '%s', '%s');", user.getId(), user.getName(),
				user.getEmail());

		return jsonUserHandler(q);
	}

	// Generic methods need to be tested
	private <T> T jsonGenericHandler(String query) throws IOException {
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonObject = client.getResponse();
			if(jsonObject == null)
				return null;
			if(jsonObject.contains("LAMP"))
				return (T) JsonJavaParser.toLampObject(jsonObject);
			else if(jsonObject.contains("FAN"))
				return (T) JsonJavaParser.toFanObject(jsonObject);
			else if(jsonObject.contains("CURTAIN"))
				return (T) JsonJavaParser.toCurtainObject(jsonObject);
			else if(jsonObject.contains("THERM"))
				return (T) JsonJavaParser.toThermObject(jsonObject);
			else if(jsonObject.contains("ALARM"))
				return (T) JsonJavaParser.toAlarmObject(jsonObject);
			else if(jsonObject.contains("WINDOW"))
				return (T) JsonJavaParser.toWindowObject(jsonObject);
		}
		return null;
	}

	public <T> T getGenericDevice(String deviceId) throws IOException {
		String query = String.format("SELECT * from devices WHERE id='%s';", deviceId);
		return jsonGenericHandler(query);
	}

	public <T> List<T> getAllDevicesGeneric(String userId, DeviceType type) throws IOException {
		String query = String.format("SELECT * from devices WHERE user_id='%s' AND type='%s';", userId, type);
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonObject = client.getResponse();
			if(jsonObject == null)
				return null;
			if(jsonObject.contains("LAMP"))
				return (List<T>) JsonJavaParser.toLampObjects(jsonObject);
			else if(jsonObject.contains("FAN"))
				return (List<T>) JsonJavaParser.toFanObjects(jsonObject);
			else if(jsonObject.contains("CURTAIN"))
				return (List<T>) JsonJavaParser.toCurtainObjects(jsonObject);
			else if(jsonObject.contains("THERM"))
				return (List<T>) JsonJavaParser.toThermObjects(jsonObject);
			else if(jsonObject.contains("ALARM"))
				return (List<T>) JsonJavaParser.toAlarmObjects(jsonObject);
			else if(jsonObject.contains("WINDOW"))
				return (List<T>) JsonJavaParser.toWindowObjects(jsonObject);
		}
		return null;
	}

	public <T> T turnDeviceOffGeneric(String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='OFF', level=" + 0.0 + " WHERE id='%s';", deviceId);
		return (T) jsonLampHandler(query);
	}

	public <T> T turnDeviceOnGeneric(String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + 80.0 + " WHERE id='%s';", deviceId);
		return (T) jsonLampHandler(query);
	}

	public <T> T deviceSlideLevelGeneric(double level, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + level + " WHERE id='%s';", deviceId);
		return (T) jsonLampHandler(query);
	}


	//  Lamp Queries ------------------------------------------------------------------------------------------
	private Lamp jsonLampHandler(String query) throws IOException {
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonObject = client.getResponse();
			if(jsonObject == null)
				return null;
			return JsonJavaParser.toLampObject(jsonObject);
		}
		return null;
	}

	public List<Lamp> getLamps(String userId) throws IOException {
		String query = String.format("SELECT * from devices WHERE user_id='%s' AND type='LAMP';", userId);
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse();
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toLampObjects(jsonArray);
		}
		return null;
	}

	public Lamp getLamp(String userId, String deviceId) throws IOException {
		String query = String.format("SELECT * from devices WHERE id='%s';", deviceId);
		return jsonLampHandler(query);
	}

	public Lamp turnLampOff(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='OFF', level=" + 0.0 + " WHERE id='%s';", deviceId);
		return jsonLampHandler(query);
	}

	public Lamp turnLampOn(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + 80.0 + " WHERE id='%s';", deviceId);
		return jsonLampHandler(query);
	}

	public Lamp slideLampLevel(String userId, String deviceId, double level) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + level + " WHERE id='%s';", deviceId);
		return jsonLampHandler(query);
	}

	// Fan Queries ------------------------------------------------------------------------------------------
	private Fan jsonFanHandler(String query) throws IOException {
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonObject = client.getResponse();
			if(jsonObject == null)
				return null;
			return JsonJavaParser.toFanObject(jsonObject);
		}
		return null;
	}

	public List<Fan> getFans(String userId) throws IOException {
		String query = String.format("SELECT * from devices WHERE user_id='%s' AND type='FAN';", userId);
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse();
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toFanObjects(jsonArray);
		}
		return null;
	}

	public Fan getFan(String userId, String deviceId) throws IOException {
		String query = String.format("SELECT * from devices WHERE id='%s';", deviceId);
		return jsonFanHandler(query);
	}

	public Fan turnFanOn(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + 80.0 + " WHERE id='%s';", deviceId);
		return jsonFanHandler(query);
	}

	public Fan turnFanOff(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='OFF', level=" + 0.0 + " WHERE id='%s';", deviceId);
		return jsonFanHandler(query);
	}

	public Fan slideFanLevel(String userId, String deviceId, double level) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + level + " WHERE id='%s';", deviceId);
		return jsonFanHandler(query);
	}

	// Curtain Queries ------------------------------------------------------------------------------------------
	private Curtain jsonCurtainHandler(String query) throws IOException {
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonObject = client.getResponse();
			if(jsonObject == null)
				return null;
			return JsonJavaParser.toCurtainObject(jsonObject);
		}
		return null;
	}

	public List<Curtain> getCurtains(String userId) throws IOException {
		String query = String.format("SELECT * from devices WHERE user_id='%s' AND type='CURTAIN';", userId);
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse();
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toCurtainObjects(jsonArray);
		}
		return null;
	}

	public Curtain getCurtain(String userId, String deviceId) throws IOException {
		String query = String.format("SELECT * from devices WHERE id ='%s';", deviceId);
		return jsonCurtainHandler(query);
	}

	public Curtain turnCurtainOn(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + 80.0 + " WHERE id='%s';", deviceId);
		return jsonCurtainHandler(query);
	}

	public Curtain turnCurtainOff(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='OFF', level=" + 0.0 + " WHERE id='%s';", deviceId);
		return jsonCurtainHandler(query);
	}

	public Curtain slideCurtainLevel(String userId, String deviceId, double level) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + level + " WHERE id='%s';", deviceId);
		return jsonCurtainHandler(query);
	}

	// Therm Queries ------------------------------------------------------------------------------------------
	private Thermometer jsonThermHandler(String query) throws IOException {
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonObject = client.getResponse();
			if(jsonObject == null)
				return null;
			return JsonJavaParser.toThermObject(jsonObject);
		}
		return null;
	}

	public List<Thermometer> getTherms(String userId) throws IOException {
		String query = String.format("SELECT * from devices WHERE user_id='%s' AND type='THERM';", userId);
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse();
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toThermObjects(jsonArray);
		}
		return null;
	}

	public Thermometer getTherm(String userId, String deviceId) throws IOException {
		String query = String.format("SELECT * from devices WHERE id ='%s';", deviceId);
		return jsonThermHandler(query);
	}

	public Thermometer setThermOn(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + 80.0 + " WHERE id='%s';", deviceId);
		return jsonThermHandler(query);
	}

	public Thermometer turnThermOff(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='OFF', level=" + 0.0 + " WHERE id='%s';", deviceId);
		return jsonThermHandler(query);
	}

	public Thermometer slideThermLevel(String userId, String deviceId, double level) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level=" + level + " WHERE id='%s';", deviceId);
		return jsonThermHandler(query);
	}

	// MP3 Queries ------------------------------------------------------------------------------------------

}
