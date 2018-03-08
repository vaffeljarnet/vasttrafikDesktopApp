package guiFX;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import parse.JSONParser;
import req.Departure;
import req.DepartureBoard;

public class Layouts {
	
	private  ArrayList<Departure> departureList;
	
	public Layouts() {}
	
	public GridPane departureBoardGrid(String stopId) {
		
		this.generateDepartureArray(stopId);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(3,20,20,20));
		grid.setVgap(5);
		grid.setHgap(10);
		
		Label lineNr = new Label("Linje");
		grid.setConstraints(lineNr, 0,1);
		Label destination = new Label("Slutstation");
		grid.setConstraints(destination, 1,1);
		Label rtTime = new Label("Ankommer");
		grid.setConstraints(rtTime, 2,1);
		
		grid.getChildren().addAll(lineNr,destination,rtTime);

		int counter1 = 3;

		for(Departure d : departureList) {

				Rectangle lineNrRect = UIGraphics.lineNrSymbol(d);
				grid.setConstraints(lineNrRect, 0,counter1);
				grid.setHalignment(lineNrRect, HPos.CENTER);

				Label lineNrText = new Label(d.lineNr());
				lineNrText.setId("bold-label-white");
				grid.setHalignment(lineNrText, HPos.CENTER);
				grid.setConstraints(lineNrText, 0,counter1);

				Label destinationText = new Label(d.destination());
				destinationText.setId("bold-label");
				grid.setConstraints(destinationText, 1,counter1);

				Label arrivalTimeText = new Label(String.valueOf(d.timeToArrivalInMinutes())+" min");
				arrivalTimeText.setId("bold-label");
				grid.setConstraints(arrivalTimeText, 2,counter1);

				counter1++;		
				grid.getChildren().addAll(lineNrRect,lineNrText,destinationText,arrivalTimeText);
			
		}
		
		return grid;
	}
	
	private void generateDepartureArray(String stopId) {
		
		DepartureBoard dBoard = new DepartureBoard();
		departureList = JSONParser.parseDepartureBoardToArray(dBoard.departureBoardByStopId(stopId));
		
		/*
		//Dummy departureBoard test Arraylist
		if(stopId.equals("9022014006790001")) {
			departureList = new ArrayList<>();
			Departure d1 = new Departure("11","Spårvagn","Saltholmen","A","23:00","23:00","2018-03-01","2018-03-01");
			Departure d2 = new Departure("9","Spårvagn","Kungsten","A","23:00","23:00","2018-03-01","2018-03-01");		
			departureList.add(d1);
			departureList.add(d2);
		}else if(stopId.equals("9022014004100003")) {
			departureList = new ArrayList<>();
			Departure d3 = new Departure("16","BUS","Frölunda Torg","A","23:00","23:00","2018-03-01","2018-03-01");
			Departure d4 = new Departure("16","BUS","Frölunda Torg","A","23:00","23:00","2018-03-01","2018-03-01");
			departureList.add(d3);
			departureList.add(d4);
			
		}
		*/
		
	}
}


