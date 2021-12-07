package homedork.code.hdapi.utility;

import com.google.gson.Gson;
import homedork.code.hdapi.model.*;
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

	public static Curtain toCurtainObject(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Curtain.class);
	}

	public static Thermometer toThermObject(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Thermometer.class);
	}

	public static Alarm toAlarmObject(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Alarm.class);
	}

	public static Window toWindowObject(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Window.class);
	}

	public static User toUserObject(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, User.class);
	}

	public static List<Lamp> toLampObjects(String json) {
		Gson gson = new Gson();
		List<Lamp> lamps = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for(int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonLampObject = (JSONObject) jsonArray.get(i);
			Lamp lampObject = gson.fromJson(jsonLampObject.toString(), Lamp.class);
			lamps.add(lampObject);
		}
		return lamps;
	}

	public static List<Fan> toFanObjects(String json) {
		Gson gson = new Gson();
		List<Fan> fans = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for(int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonFanObject = (JSONObject) jsonArray.get(i);
			Fan fanObject = gson.fromJson(jsonFanObject.toString(), Fan.class);
			fans.add(fanObject);
		}
		return fans;
	}

	public static List<Curtain> toCurtainObjects(String json) {
		Gson gson = new Gson();
		List<Curtain> curtains = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for(int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonCurtainObject = (JSONObject) jsonArray.get(i);
			Curtain curtainObject = gson.fromJson(jsonCurtainObject.toString(), Curtain.class);
			curtains.add(curtainObject);
		}
		return curtains;
	}

	public static List<Thermometer> toThermObjects(String json) {
		Gson gson = new Gson();
		List<Thermometer> therms = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for(int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonThermObject = (JSONObject) jsonArray.get(i);
			Thermometer thermObject = gson.fromJson(jsonThermObject.toString(), Thermometer.class);
			therms.add(thermObject);
		}
		return therms;
	}

	public static List<Alarm> toAlarmObjects(String json) {
		Gson gson = new Gson();
		List<Alarm> alarms = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for(int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonAlarmObject = (JSONObject) jsonArray.get(i);
			Alarm alarmObject = gson.fromJson(jsonAlarmObject.toString(), Alarm.class);
			alarms.add(alarmObject);
		}
		return alarms;
	}

	public static List<Window> toWindowObjects(String json) {
		Gson gson = new Gson();
		List<Window> windows = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for(int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonWindowObject = (JSONObject) jsonArray.get(i);
			Window windowObject = gson.fromJson(jsonWindowObject.toString(), Window.class);
			windows.add(windowObject);
		}
		return windows;
	}

	public static List<Device> toDeviceObjects(String json) {
		Gson gson = new Gson();
		List<Device> Devices = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for(int i = 0; i < jsonArray.toList().size(); i++) {
			JSONObject jsonDeviceObject = (JSONObject) jsonArray.get(i);
			Device deviceObject = gson.fromJson(jsonDeviceObject.toString(), Device.class);
			Devices.add(deviceObject);
		}
		return Devices;
	}
}
