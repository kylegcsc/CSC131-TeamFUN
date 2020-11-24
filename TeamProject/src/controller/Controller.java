package controller;

import application.Calculator;
import application.OperationStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
	
	private boolean operatorMode = false;	
	private boolean entryIsResult = false;
	private boolean entryIsEvaluation = false;
	
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
	private Calculator calc = Calculator.get();
	
	// Called by FXML button
	public void pressDigit(ActionEvent event) {
		int digit = ((DigitButton) event.getSource()).getDigit();
		
		if(entryIsEvaluation == true) {
			display.clearExpression();
			entryIsEvaluation = false;
		}
		
		if(entryIsResult == true || operatorMode == true) {
			display.clearEntry();		
			
			entryIsResult = false;
			operatorMode = false;
		}
		
		display.putEntryDigit(digit);
	}
	
	public void pressOperator(ActionEvent event) {
		operatorMode = true;
					
		if(display.isExpressionEmpty()) {
			calc.setValue(display.getEntry());
		} else {
			calc.evaluate(display.getEntry());
		}		
		
		OperationStrategy operation = ((OperationButton) event.getSource()).getOperation();			
		calc.setOperation(operation);
		
		if(entryIsEvaluation == true) {
			display.clearExpression();	
			entryIsEvaluation = false;
		}			
		
		display.putEntryInExpression();
		display.appendExpressionOperator(operation.getChar());
	}
	
	public void evaluate() {
		display.putEntryInExpression();
		display.appendExpressionOperator('=');
		
		calc.evaluate(display.getEntry());
		display.putEvaluatedValueInEntry(calc.getValue());
		
		entryIsResult = true;
		entryIsEvaluation = true;
		operatorMode = false;
	}
	
	/*
	// Called by FXML button
	public void pressOperator(ActionEvent event) {
		double expressionValue = 0.0;
		String operator = "";
		
		OperationButton source = (OperationButton) event.getSource();
		OperationStrategy operation = source.getOperation();
		Calculator.get().setValue(display.getEntry());
		Calculator.get().setOperation(operation);
		expressionValue = Calculator.get().getValue();
		operator = source.getOperationString();
		
		if(operatorMode) {
			evaluate();
		} else {
			operatorMode = true;
			//display.setEntry(Calculator.get().getValue());
			display.clearEntry();
		}
		
		// Update expression display
		display.putExpressionValue(expressionValue);
		display.putOperator(operator);
	}
	*/
	
	//public void evaluate() {
//		double operand = display.getEntry();
//		Calculator.get().evaluate(operand);				
//		operatorMode = false;		
//		display.setEntry(Calculator.get().getValue());
	//}
	
	// Called by FXML button
	public void clear() {
		entryIsResult = false;
		entryIsEvaluation = false;
		operatorMode = false;
		
		display.clearEntry();
		display.clearExpression();
		
		calc.reset();
	}
	
	public void clearEntry() {
		
		//display.clearEntry();
	}
	
}
