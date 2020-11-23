package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
	
//	@FXML private Button button_0;
//	@FXML private Button button_1;
//	@FXML private Button button_2;
//	@FXML private Button button_3;
//	@FXML private Button button_4;
//	@FXML private Button button_5;
//	@FXML private Button button_6;
//	@FXML private Button button_7;
//	@FXML private Button button_8;
//	@FXML private Button button_9;
//	@FXML private Button button_multiply;
//	@FXML private Button button_divide;
//	@FXML private Button button_add;
//	@FXML private Button button_subtract;
//	@FXML private Button button_decimal;
//	@FXML private Button button_delete;
//	@FXML private Button button_clear;
//	@FXML private Button button_clearentry;
	
	@FXML private Display display;
	
	@FXML
	public void pressDigit(ActionEvent event) {
		int digit = ((DigitButton) event.getSource()).getDigit();
		display.addExpressionDigit(digit);
	}
}
