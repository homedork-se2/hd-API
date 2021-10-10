package homedork.code.hdapi.utility;

import com.google.gson.Gson;
import homedork.code.hdapi.model.Device;
import homedork.code.hdapi.model.Fan;
import homedork.code.hdapi.model.Lamp;
import homedork.code.hdapi.model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonJavaParser {

	public static Lamp toLampObject(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Lamp.class);
	}

	public static Fan toFanObject(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Fan.class);
	}

	public static User toUserObject(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, User.class);
	}

	public static List<Lamp> toLampObjects(String json) {
		Gson gson = new Gson();
		List<Lamp> lamps = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for (int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonLampObject = (JSONObject) jsonArray.get(i);
			Lamp lampObject = gson.fromJson(jsonLampObject.toString(),Lamp.class);
			lamps.add(lampObject);
		}
		return lamps;
	}

	public static List<Fan> toFanObjects(String json) {
		Gson gson = new Gson();
		List<Fan> fans = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for (int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonFanObject = (JSONObject) jsonArray.get(i);
			Fan fanObject = gson.fromJson(jsonFanObject.toString(),Fan.class);
			fans.add(fanObject);
		}
		return fans;
	}

	public static List<Device> toDeviceObjects(String json) {
		Gson gson = new Gson();
		List<Device> Devices = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for (int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonFanObject = (JSONObject) jsonArray.get(i);
			Device fanObject = gson.fromJson(jsonFanObject.toString(),Device.class);
			Devices.add(fanObject);
		}
		return Devices;
	}
}
