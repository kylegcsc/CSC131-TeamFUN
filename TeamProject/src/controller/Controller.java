package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
	
	@FXML private Display display;
	
	// Called by FXML button
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
