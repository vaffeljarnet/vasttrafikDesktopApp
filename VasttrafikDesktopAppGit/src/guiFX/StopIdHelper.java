package guiFX;

public class StopIdHelper {

	private StopIdHelper() {}

	public static String matchStopId(String stopName) {
		switch(stopName) {
		case "Kunggsten": return "9022014004100003";		
		case "Tolvskillingsgatan": return "9022014006790001";
		case "Varbergsgatan": return "9021014007270000";	
		case "Utlandagatan": return "9021014007190000";		
		}
		
		return "9022014004100003";
	}

}
