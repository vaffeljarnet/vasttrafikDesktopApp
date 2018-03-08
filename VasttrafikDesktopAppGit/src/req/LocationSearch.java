package req;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import auth.AccessTokenHandler;

public class LocationSearch {
	
	public LocationSearch() {}
	
	/**
	 * Calls Västtrafiks location.nearbystops function that returns 
	 * a maximum of 5 stops nearby the given longitude and latitude
	 * coordinates as a JSONObject.
	 * @param longitude - String
	 * @param latitude - String
	 * @return JSONObject
	 */
	public JSONObject nearbyStopsByCoordinates(String longitude, String latitude) {
		
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("https://api.vasttrafik.se/bin/rest.exe/v2/location.nearbystops?originCoordLong="+longitude+"&originCoordLat="+latitude+"&maxNo=5&format=json");
		String accessToken = AccessTokenHandler.generateAccessToken();
		try {		
			httpGet.addHeader("Authorization", "Bearer "+accessToken);
			HttpResponse response = httpclient.execute(httpGet);
			JSONObject jsonResponse = new JSONObject(EntityUtils.toString(response.getEntity()));		
			return jsonResponse;			
		}catch(ClientProtocolException e) {
			System.err.println("Kritiskt fel. Returnerar null.");
			e.printStackTrace();
		}catch(IOException e) {
			System.err.println("Kritiskt fel. Returnerar null.");
			e.printStackTrace();
		}catch(JSONException e) {
			System.err.println("Kritiskt fel. Returnerar null.");
			e.printStackTrace();		
		}		
		return null;			
	}
	
	/**
	 * Calls Västtrafiks Nearbystops-function that returns a maximum of 5 stops 
	 * nearby the given longitude and latitude coordinates as a JSONObject. 
	 * Uses manual input for access token. 
	 * @param longitude - String
	 * @param latitude - String
	 * @param accessToken - String with valid access token from Västtrafik
	 * @return JSONObject
	 */
	public JSONObject nearbyStopsManualAccessToken(String longitude, String latitude, String accessToken) {
		
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("https://api.vasttrafik.se/bin/rest.exe/v2/location.nearbystops?originCoordLong="+longitude+"&originCoordLat="+latitude+"&maxNo=5&format=json");
		try {		
			httpGet.addHeader("Authorization", "Bearer "+accessToken);
			HttpResponse response = httpclient.execute(httpGet);
			JSONObject jsonResponse = new JSONObject(EntityUtils.toString(response.getEntity()));		
			return jsonResponse;			
		}catch(ClientProtocolException e) {
			System.err.println("Kritiskt fel. Returnerar null.");
			e.printStackTrace();
		}catch(IOException e) {
			System.err.println("Kritiskt fel. Returnerar null.");
			e.printStackTrace();
		}catch(JSONException e) {
			System.err.println("Kritiskt fel. Returnerar null.");
			e.printStackTrace();		
		}		
		return null;			
	}
	
	/**
	 * Calls Västtrafiks' location.name function and returns a JSON object
	 * containing the closets matching stations based on the given charachter
	 * or word.
	 * @param stopName - String, with desired search term
	 * @return JSONObject
	 */
	public JSONObject stopsByName(String stopName) {
			
			HttpClient httpclient = HttpClientBuilder.create().build();
			HttpGet httpGet = new HttpGet("https://api.vasttrafik.se/bin/rest.exe/v2/location.name?input="+stopName+"&format=json");
			String accessToken = AccessTokenHandler.generateAccessToken();
			try {		
				httpGet.addHeader("Authorization", "Bearer "+accessToken);
				HttpResponse response = httpclient.execute(httpGet);
				JSONObject jsonResponse = new JSONObject(EntityUtils.toString(response.getEntity()));		
				return jsonResponse;			
			}catch(ClientProtocolException e) {
				System.err.println("Kritiskt fel. Returnerar null.");
				e.printStackTrace();
			}catch(IOException e) {
				System.err.println("Kritiskt fel. Returnerar null.");
				e.printStackTrace();
			}catch(JSONException e) {
				System.err.println("Kritiskt fel. Returnerar null.");
				e.printStackTrace();		
			}		
			return null;					
	}
	
	

}
