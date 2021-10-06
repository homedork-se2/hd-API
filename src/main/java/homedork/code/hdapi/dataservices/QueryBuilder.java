package homedork.code.hdapi.dataservices;

import homedork.code.hdapi.comm.Client;
import homedork.code.hdapi.model.Lamp;
import homedork.code.hdapi.utility.JsonJavaParser;

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
	public Lamp turnUserLightOff(String userId, String deviceId) throws IOException {
		String query = "UPDATE devices SET state='off' WHERE deviceId=" + "'" + deviceId + "' AND WHERE userId='" + userId + "'";
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonObject = client.getResponse(); // handle json object here - utility class?
			return JsonJavaParser.toLampObject(jsonObject); // lamp java object returned!
		}
		return null;
	}

	// test : example
	public List<Lamp> getLamps(String userId) throws IOException {
		String query = "SELECT from devices WHERE userId='" + userId + "' AND deviceType='LAMP'";
		boolean b = client.sendQuery(query);

		if(b) {
			String jsonArray = client.getResponse(); // handle json object here - utility class?
			return JsonJavaParser.toLampObjects(jsonArray); // lamp java object returned!
		}
		return null;
	}
}
