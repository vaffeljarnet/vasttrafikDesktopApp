package parse;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import req.Departure;

public class JSONParser {
	
	private JSONParser() {}

	/**
	 * Takes a response from Västrafiks API function departureBoard and parses it to 15 
	 * Departure instances which are put in to the returned ArrayList.
	 * @param response JSONObject - Needs to be a response from DepartureBoard
	 * @return ArrayList<Departure>
	 */
	public static ArrayList<Departure> parseDepartureBoardToArray(JSONObject response){
		ArrayList<Departure> departures = new ArrayList<Departure>();
		try {
			JSONArray departuresArray = response.getJSONObject("DepartureBoard").getJSONArray("Departure");
			//Change for-loop to i<departuresArray.length to get all 20 departures
			for(int i =0;i<15;i++) {				
					Departure d = new Departure(departuresArray.getJSONObject(i).getString("sname").toString(),
							departuresArray.getJSONObject(i).getString("type").toString(),
							departuresArray.getJSONObject(i).getString("direction").toString(),
							departuresArray.getJSONObject(i).getString("track").toString(),
							departuresArray.getJSONObject(i).getString("time").toString(),
							departuresArray.getJSONObject(i).getString(departuresArray.getJSONObject(i).toString().contains("rtTime") ? "rtTime" : "time").toString(),
							departuresArray.getJSONObject(i).getString("date").toString(),
							departuresArray.getJSONObject(i).getString(departuresArray.getJSONObject(i).toString().contains("rtTime") ? "rtDate" : "date").toString()
							);
					departures.add(d); 				
			}						
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return departures;
	}
	
	/**
	 * Reformats a provided String object with JSON response to an easier readable format.
	 * @param jsonString String object containing JSON response
	 * @return Reformated easier readable JSON response
	 */
	public String toPrettyJson(String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonString).getAsJsonObject();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = gson.toJson(json);
		
		return prettyJson;
	}

}