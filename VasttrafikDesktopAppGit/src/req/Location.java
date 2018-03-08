package req;

public class Location {
	
	private String name;
	private String longitude;
	private String latitude;
	private String stopId;
	
	public Location(String name, String longitude, String latitude, String stopId) {
		this.name=name;
		this.longitude=longitude;
		this.latitude=latitude;
		this.stopId=stopId;
	}
	
	public String getName() {
		return name;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getStopId() {
		return stopId;
	}	

}
