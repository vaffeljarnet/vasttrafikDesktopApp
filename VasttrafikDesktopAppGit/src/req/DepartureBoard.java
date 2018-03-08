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

public class DepartureBoard {
	
	public DepartureBoard() {
		
	}
	
	/**
	 * Performs a get request to Västrafiks' DepartureBoard function
	 * by stop id.
	 * @return JSONObject with the response of the get request.
	 */
	public JSONObject departureBoardByStopId(String stopId) {
		
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("https://api.vasttrafik.se/bin/rest.exe/v2/departureBoard?id="+stopId+"&format=json&maxDeparturesPerLine=2&needJourneyDetail=0");
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
	 * Performs a get request to Västrafiks' departureBoard function with
	 * manually generated access token and stop id.
	 * @param stopId
	 * @return JSONObject with the response of the get request.
	 */
	public JSONObject departureBoardCustomAccessToken(String accessToken, String stopId) {
		
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("https://api.vasttrafik.se/bin/rest.exe/v2/departureBoard?id="+stopId+"&format=json&maxDeparturesPerLine=2&needJourneyDetail=0");
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
