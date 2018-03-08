package main;

import java.util.ArrayList;

import guiFX.Layouts;
import guiFX.StopIdHelper;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import parse.JSONParser;
import req.Departure;
import req.DepartureBoard;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DepartureBoardApp extends Application{

	Scene departureList;
	Stage mainWindow;
	String stopId = "9022014004100003";
	GridPane grid;
	Layouts layout = new Layouts();
	BorderPane mainScene = new BorderPane();

	@Override
	public void start(Stage primaryStage) {

		mainWindow = primaryStage;
		mainWindow.setTitle("Nästa tur");
		mainWindow.getIcons().add(new Image(DepartureBoardApp.class.getResourceAsStream("appIcon.png")));

		grid = layout.departureBoardGrid(stopId);
		
		HBox topMenu = new HBox();
		topMenu.setPadding(new Insets(5,20,5,20));
		topMenu.setSpacing(10);
		
		ChoiceBox<String> stopList = new ChoiceBox<>();
		stopList.getItems().addAll("Kungssten","Tolvskillingsgatan","Varbergsgatan","Utlandagatan");	
		stopList.setValue("Kungssten");
		stopList.setPrefSize(205, 35);
		
		stopList.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> stopListSelection(newValue));
		
		Button update = new Button("Uppdatera");
		update.setOnAction(e -> updateButton());
		update.setPrefSize(85, 35);
		
		topMenu.getChildren().addAll(stopList,update);
		
		mainScene.setTop(topMenu);
		mainScene.setCenter(grid);
		
		departureList = new Scene(mainScene,440,640);
		departureList.getStylesheets().add("styling.css");
		mainWindow.setScene(departureList);
		mainWindow.setResizable(false);
		mainWindow.show();

	}
	
	public void stopListSelection(String newValue) {
		stopId = StopIdHelper.matchStopId(newValue);
		
		grid = layout.departureBoardGrid(stopId);				
		mainScene.setCenter(grid);		
		mainWindow.setScene(departureList);
	}
	
	private void updateButton() {
		grid = layout.departureBoardGrid(stopId);				
		mainScene.setCenter(grid);
		mainWindow.setScene(departureList);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
