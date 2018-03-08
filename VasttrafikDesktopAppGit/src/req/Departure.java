package req;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Departure {

	private String lineNr;
	private String vehicleType;
	private String destination;
	private String track;
	private String time;
	private String realTime;
	private String date;
	private String realDate;
	
	public Departure(String lineNr, String vehicleType, String destination, String track, String timeTable,
			String realTime, String date, String realDate) {		
		this.lineNr = lineNr;
		this.vehicleType = vehicleType;
		this.destination = destination;
		this.track = track;
		this.time = timeTable;
		this.realTime = realTime;
		this.date = date;
		this.realDate = realDate;
	}

	public String lineNr() {
		return lineNr;
	}

	public String vehicleType() {
		return vehicleType;
	}

	public String destination() {
		return destination;
	}

	public String track() {
		return track;
	}

	public String timeTable() {
		return time;
	}

	public String realTime() {
		return realTime;
	}
	
	public String date() {
		return date;
	}
	
	public String realDate() {
		return date;
	}
	
	
	/**
	 * Takes the current realtime arrival(possible delay) at the called upon stop of 
	 * the Departure and calculates time to arrival in minutes.
	 * @return long
	 */
	public long timeToArrivalInMinutes() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String now = dateFormat.format(Calendar.getInstance().getTime());
		Date date1;
		Date date2;
		String arrivalTime = this.realDate +" "+this.realTime;
		try {
			date1 = dateFormat.parse(now);
			date2 = dateFormat.parse(arrivalTime);
			return (date2.getTime() - date1.getTime()) / 60000;
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return this.lineNr+" "+this.destination+" "+this.timeToArrivalInMinutes();
	}
	
	
	
	
	
	
}
