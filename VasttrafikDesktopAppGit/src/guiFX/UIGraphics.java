package guiFX;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import req.Departure;

public class UIGraphics {
	
	private UIGraphics() {}
	
	public static Rectangle lineNrSymbol(Departure departure) {
		Rectangle rect = new Rectangle(30,30,30,30);		
		rect.setArcHeight(12);
		rect.setArcWidth(12);
		
		if(departure.lineNr().equals("9")) {
			rect.setFill(Color.rgb(106, 167, 252));
		}else if(departure.lineNr().equals("11")) {
			rect.setFill(Color.rgb(54, 55, 56));
		}else if(departure.lineNr().equals("4")) {
			rect.setFill(Color.rgb(51, 183, 93));
		}else if(departure.lineNr().equals("2")) {
			rect.setFill(Color.rgb(239, 233, 64));
		}else if(departure.vehicleType().equals("BUS")) {
			rect.setFill(Color.rgb(31, 101, 193));
		}
		
		
		return rect;
	}

}
