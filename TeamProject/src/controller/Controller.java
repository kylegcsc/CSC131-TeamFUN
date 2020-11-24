package controller;

import application.Calculator;
import application.OperationStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
	
	@FXML private DigitButton button_0;
	@FXML private DigitButton button_1;
	@FXML private DigitButton button_2;
	@FXML private DigitButton button_3;
	@FXML private DigitButton button_4;
	@FXML private DigitButton button_5;
	@FXML private DigitButton button_6;
	@FXML private DigitButton button_7;
	@FXML private DigitButton button_8;
	@FXML private DigitButton button_9;
	@FXML private OperationButton button_multiply;
	@FXML private OperationButton button_divide;
	@FXML private OperationButton button_add;
	@FXML private OperationButton button_subtract;
	@FXML private Button button_decimal;
	@FXML private Button button_delete;
	@FXML private Button button_clear;
	@FXML private Button button_clearentry;
	@FXML private Button button_evaluate;
	
	@FXML private Display display;
	
	// Called by FXML button
	public void pressDigit(ActionEvent event) {
		int digit = ((DigitButton) event.getSource()).getDigit();
		display.putDigit(digit);
	}
	
	// Called by FXML button
	public void pressOperator(ActionEvent event) {
		OperationButton source = (OperationButton) event.getSource();
		OperationStrategy operation = source.getOperation();
		Calculator.get().setOperation(operation).evaluate(5);
		display.putOperator(source.getOperationString());
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
