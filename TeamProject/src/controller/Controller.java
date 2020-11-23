package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
	
	@FXML private Display display;
	
	public void pressDigit(ActionEvent event) {
		int digit = ((DigitButton) event.getSource()).getDigit();
		display.addExpressionDigit(digit);
	}
	
	// Called by FXML button
	public void clear() {
		display.clear();
	}
	
	// Called by FXML button 
	public void clearEntry() {
		display.clearEntry();
	}
	
}
