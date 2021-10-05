package homedork.code.hdapi.utility;

import com.google.gson.Gson;
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

	static Fan toFanObject(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Fan.class);
	}

	static User toUserObject(String json) {
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
}
