package homedork.code.hdapi.dataservices;

import homedork.code.hdapi.comm.Client;
import homedork.code.hdapi.model.Device;
import homedork.code.hdapi.model.DeviceType;
import homedork.code.hdapi.model.User;
import homedork.code.hdapi.utility.JsonJavaParser;

import java.io.IOException;
import java.util.ArrayList;
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

        if (b) {
            String jsonArray = client.getResponse();
            if (jsonArray == null)
                return null;
            return JsonJavaParser.toDeviceObjects(jsonArray);
        }
        return null;
    }

    // User Queries ------------------------------------------------------------------------------------------

    private User jsonUserHandler(String query) throws IOException {
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonObject = client.getResponse();
            if (jsonObject == null)
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

    public User deleteUser(String userId) throws IOException {
        String query = String.format("Delete * from users INNER JOIN devices WHERE users.id = devices.user_id and users.user_id = '%s';", userId);
        return jsonUserHandler(query);
    }

    public String getFreePin(String userId, String deviceType) {
        String contactor = String.format("FREE-PIN %s %s",userId, deviceType);
        boolean b = client.sendQuery(contactor);

        try {
            if(b) {
                return client.getResponse();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Generic methods need to be tested
    @SuppressWarnings("unchecked")
    private <T> T jsonGenericHandler(String query) throws IOException {
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonObject = client.getResponse();
            if (jsonObject == null)
                return null;
            if (jsonObject.contains("LAMP"))
                return (T) JsonJavaParser.toLampObject(jsonObject);
            else if (jsonObject.contains("FAN"))
                return (T) JsonJavaParser.toFanObject(jsonObject);
            else if (jsonObject.contains("CURTAIN"))
                return (T) JsonJavaParser.toCurtainObject(jsonObject);
            else if (jsonObject.contains("THERM"))
                return (T) JsonJavaParser.toThermObject(jsonObject);
            else if (jsonObject.contains("ALARM"))
                return (T) JsonJavaParser.toAlarmObject(jsonObject);
            else if (jsonObject.contains("WINDOW"))
                return (T) JsonJavaParser.toWindowObject(jsonObject);
        }
        return null;
    }
  
    public <T> T getGenericDevice(String deviceId) throws IOException {
        String query = String.format("SELECT * from devices WHERE id='%s';", deviceId);
        return jsonGenericHandler(query);
    }
  
  	/**
	 * @param userId - user's ID
	 * @param type   - device type
	 * @param <T>    - Type of list returned
	 * @return - List of devices
	 */
    @SuppressWarnings("unchecked")
    public <T> List<T> getAllDevicesGeneric(String userId, DeviceType type) throws IOException {
        String query = String.format("SELECT * from devices WHERE user_id='%s' AND type='%s';", userId, type);
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonObject = client.getResponse();
            if (jsonObject == null)
                return null;
            if (jsonObject.contains("LAMP"))
                return (List<T>) JsonJavaParser.toLampObjects(jsonObject);
            else if (jsonObject.contains("FAN"))
                return (List<T>) JsonJavaParser.toFanObjects(jsonObject);
            else if (jsonObject.contains("CURTAIN"))
                return (List<T>) JsonJavaParser.toCurtainObjects(jsonObject);
            else if (jsonObject.contains("THERM"))
                return (List<T>) JsonJavaParser.toThermObjects(jsonObject);
            else if (jsonObject.contains("ALARM"))
                return (List<T>) JsonJavaParser.toAlarmObjects(jsonObject);
            else if (jsonObject.contains("WINDOW"))
                return (List<T>) JsonJavaParser.toWindowObjects(jsonObject);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T> T turnDeviceOffGeneric(String deviceId, DeviceType type) throws IOException {
        String query;
        if (type == DeviceType.WINDOW)
            query = String.format("UPDATE devices SET state='CLOSED', level=" + 0.0 + " WHERE id='%s';", deviceId);
        else
            query = String.format("UPDATE devices SET state='OFF', level=" + 0.0 + " WHERE id='%s';", deviceId);

        return (T) jsonGenericHandler(query);
    }

    @SuppressWarnings("unchecked")
    public <T> T turnDeviceOnGeneric(String deviceId, DeviceType type) throws IOException {
        String query;
        if (type == DeviceType.WINDOW)
            query = String.format("UPDATE devices SET state='OPEN', level=" + 80.0 + " WHERE id='%s';", deviceId);
        else
            query = String.format("UPDATE devices SET state='ON', level=" + 80.0 + " WHERE id='%s';", deviceId);

        return (T) jsonGenericHandler(query);
    }

    @SuppressWarnings("unchecked")
    public <T> T deviceSlideLevelGeneric(double level, String deviceId, DeviceType type) throws IOException {
        String query;
        if (type == DeviceType.WINDOW)
            query = String.format("UPDATE devices SET state='OPEN', level=" + level + " WHERE id='%s';", deviceId);
        else
            query = String.format("UPDATE devices SET state='ON', level=" + level + " WHERE id='%s';", deviceId);

        return (T) jsonGenericHandler(query);
    }

    public <T> T deleteGenericDevice(String deviceId) throws IOException {
        String query = String.format("DELETE * from devices WHERE id='%s';", deviceId);
        return jsonGenericHandler(query);
    }

	public <T> T removeDevice(String deviceId) throws IOException {
		String query = String.format("DELETE FROM devices WHERE id='%s';", deviceId);
		return jsonGenericHandler(query);
	}
}
