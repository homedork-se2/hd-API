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


	// test : example
	public Lamp turnUserLightOffTest(String userId, String deviceId) throws IOException {
		String query = "UPDATE devices SET state='off' WHERE deviceId=" + "'" + deviceId + "' AND WHERE userId='" + userId + "';";
		return (Lamp) jsonLampHandler(query);
	}

	// test : example
	public List<Lamp> getLampsTest(String userId) throws IOException {
		String query = "SELECT * from devices WHERE userId='" + userId + "' AND deviceType='LAMP';";
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse(); // handle json object here - utility class?
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toLampObjects(jsonArray); // lamp java object returned!
		}
		return null;
	}

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
		String query = String.format("SELECT * from devices WHERE id='%s';", userId);
		return jsonUserDevicesHandler(query);
	}

	public User addNewUser(@NotNull User user) throws IOException {
		// INSERT INTO `users` (`id`, `name`, `email`) VALUES ('dada', 'dada', 'dada');
		String q = String.format("INSERT INTO `users` (`id`, `name`, `email`) VALUES ('%s', '%s', '%s');", user.getId(), user.getName(),
				user.getEmail());

		return jsonUserHandler(q);
	}

	//  Lamp Queries ------------------------------------------------------------------------------------------
	public List<Lamp> getLamps(String userId) throws IOException {
		String query = String.format("SELECT * from devices WHERE userId='%s' AND deviceType='LAMP';", userId);
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse();
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toLampObjects(jsonArray);
		}
		return null;
	}

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

	public Lamp getLamp(String userId, String deviceId) throws IOException {
		String query = String.format("SELECT * from devices WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonLampHandler(query);
	}

	public Lamp turnLampOff(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='OFF' AND level='0.0' WHERE id='%s';", deviceId);
		return jsonLampHandler(query);
	}

	public Lamp turnLampOn(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='ON' WHERE id='%s';", deviceId);
		return jsonLampHandler(query);
	}

	public Lamp slideLampLevel(String userId, String deviceId, double level) throws IOException {
		String query = String.format("UPDATE devices SET state='ON', level='%f' WHERE id='%s';", level, deviceId);
		return jsonLampHandler(query);
	}

	// Fan Queries ------------------------------------------------------------------------------------------
	public List<Fan> getFans(String userId) throws IOException {
		String query = String.format("SELECT * from devices WHERE userId='%s' AND deviceType='FAN';", userId);
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse();
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toFanObjects(jsonArray);
		}
		return null;
	}

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

	public Fan getFan(String userId, String deviceId) throws IOException {
		String query = String.format("SELECT * from devices WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonFanHandler(query);
	}

	public Fan setFanOn(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='on' WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonFanHandler(query);
	}

	public Fan turnFanOff(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='off' AND level='0.0' WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonFanHandler(query);
	}

	public Fan slideFanLevel(String userId, String deviceId, double level) throws IOException {
		String query = String.format("UPDATE devices SET state='on' AND level='%s' WHERE deviceId='%s' AND WHERE userId='%s';", level, deviceId, userId);
		return jsonFanHandler(query);
	}

	// Curtain Queries ------------------------------------------------------------------------------------------

	public List<Curtain> getCurtains(String userId) throws IOException {
		String query = String.format("SELECT * from devices WHERE userId='%s' AND deviceType='FAN';", userId);
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse();
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toCurtainObjects(jsonArray);
		}
		return null;
	}

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

	public Curtain getCurtain(String userId, String deviceId) throws IOException {
		String query = String.format("SELECT * from devices WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonCurtainHandler(query);
	}

	public Curtain setCurtainOn(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='on' WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonCurtainHandler(query);
	}

	public Curtain turnCurtainOff(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='off' AND level='0.0' WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonCurtainHandler(query);
	}

	public Curtain slideCurtainLevel(String userId, String deviceId, double level) throws IOException {
		String query = String.format("UPDATE devices SET state='on' AND level='%s' WHERE deviceId='%s' AND WHERE userId='%s';", level, deviceId, userId);
		return jsonCurtainHandler(query);
	}

	// Therm Queries ------------------------------------------------------------------------------------------
	public List<Thermometer> getTherms(String userId) throws IOException {
		String query = String.format("SELECT * from devices WHERE userId='%s' AND deviceType='FAN';", userId);
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse();
			if(jsonArray == null)
				return null;
			return JsonJavaParser.toThermObjects(jsonArray);
		}
		return null;
	}

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

	public Thermometer getTherm(String userId, String deviceId) throws IOException {
		String query = String.format("SELECT * from devices WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonThermHandler(query);
	}

	public Thermometer setThermOn(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='on' WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonThermHandler(query);
	}

	public Thermometer turnThermOff(String userId, String deviceId) throws IOException {
		String query = String.format("UPDATE devices SET state='off' AND level='0.0' WHERE deviceId='%s' AND WHERE userId='%s';", deviceId, userId);
		return jsonThermHandler(query);
	}

	public Thermometer slideThermLevel(String userId, String deviceId, double level) throws IOException {
		String query = String.format("UPDATE devices SET state='on' AND level='%s' WHERE deviceId='%s' AND WHERE userId='%s';", level, deviceId, userId);
		return jsonThermHandler(query);
	}

	// MP3 Queries ------------------------------------------------------------------------------------------

}
