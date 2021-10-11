package homedork.code.hdapi.dataservices;

import homedork.code.hdapi.comm.Client;
import homedork.code.hdapi.model.*;
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
    public Lamp turnUserLightOffTest(String userId, String deviceId) throws IOException {
        String query = "UPDATE devices SET state='off' WHERE deviceId=" + "'" + deviceId + "' AND WHERE userId='" + userId + "';";
        return (Lamp) jsonLampHandler(query);
    }

    // test : example
    public List<Lamp> getLampsTest(String userId) throws IOException {
        String query = "SELECT from devices WHERE userId='" + userId + "' AND deviceType='LAMP';";
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonArray = client.getResponse(); // handle json object here - utility class?
            return JsonJavaParser.toLampObjects(jsonArray); // lamp java object returned!
        }
        return null;
    }

    private Lamp jsonLampHandler(String query) throws IOException {
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonObject = client.getResponse();
            return JsonJavaParser.toLampObject(jsonObject);
        }
        return null;
    }

    private Fan jsonFanHandler(String query) throws IOException {
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonObject = client.getResponse();
            return JsonJavaParser.toFanObject(jsonObject);
        }
        return null;
    }

    private User jsonUserHandler(String query) throws IOException {
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonObject = client.getResponse();
            return JsonJavaParser.toUserObject(jsonObject);
        }
        return null;
    }

    private List<Device> jsonUserDevicesHandler(String query) throws IOException {
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonArray = client.getResponse();
            return JsonJavaParser.toDeviceObjects(jsonArray);
        }
        return null;
    }

    // User Queries
    public User getUser(String userId) throws IOException {
        String query = "SELECT from users WHERE userId='" + userId + "';";
        return jsonUserHandler(query);
    }

    public List<Device> getDevices(String userId) throws IOException {
        String query = "SELECT from devices WHERE userId='" + userId + "';";
        return jsonUserDevicesHandler(query);
    }

    //  Light Queries
    public List<Lamp> getLamps(String userId) throws IOException {
        String query = "SELECT from devices WHERE userId='" + userId + "' AND deviceType='LAMP';";
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonArray = client.getResponse();
            return JsonJavaParser.toLampObjects(jsonArray);
        }
        return null;
    }

    public Lamp getLamp(String userId, String lampId) throws IOException {
        String query = "SELECT from devices WHERE userId='" + userId + "' AND deviceId='" + lampId + "';";
        return jsonLampHandler(query);
    }

    public Lamp turnLampOff(String userId, String deviceId) throws IOException {
        String query = "UPDATE devices SET state='on' AND level='0.0' WHERE deviceId=" + "'" + deviceId + "' AND WHERE userId='" + userId + "';";
        return jsonLampHandler(query);
    }

    public Lamp turnLampOn(String userId, String deviceId) throws IOException {
        String query = "UPDATE devices SET state='on' WHERE deviceId=" + "'" + deviceId + "' AND WHERE userId='" + userId + "';";
        return jsonLampHandler(query);
    }

    public Lamp slideLampOn(String userId, String deviceId, double level) throws IOException {
        String query = "UPDATE devices SET state='on' AND level='" + level + "' WHERE deviceId=" + "'" + deviceId + "' AND WHERE userId='" + userId + "';";
        return jsonLampHandler(query);
    }

    // Fan Queries
    public List<Fan> getFans(String userId) throws IOException {
        String query = "SELECT from devices WHERE userId='" + userId + "' AND deviceType='FAN';";
        boolean b = client.sendQuery(query);

        if (b) {
            String jsonArray = client.getResponse();
            return JsonJavaParser.toFanObjects(jsonArray);
        }
        return null;
    }

    public Fan getFan(String userId, String fanId) throws IOException {
        String query = "SELECT from devices WHERE userId='" + userId + "' AND deviceId='" + fanId + "';";
        return jsonFanHandler(query);
    }

    public Fan setFanOn(String userId, String deviceId) throws IOException {
        String query = "UPDATE devices SET state='on' WHERE deviceId=" + "'" + deviceId + "' AND WHERE userId='" + userId + "';";
        return jsonFanHandler(query);
    }

    public Fan turnFanOff(String userId, String deviceId) throws IOException {
        String query = "UPDATE devices SET state='off' AND AND level='0.0' WHERE deviceId=" + "'" + deviceId + "' AND WHERE userId='" + userId + "';";
        return jsonFanHandler(query);
    }

    public Fan slideFanOn(String userId, String deviceId, double level) throws IOException {
        String query = "UPDATE devices SET state='on' AND level='" + level + "' WHERE deviceId=" + "'" + deviceId + "' AND WHERE userId='" + userId + "';";
        return jsonFanHandler(query);
    }
}
