package controller;

import application.Calculator;
import application.OperationStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
	
	private boolean operatorMode = false;	
	private boolean entryIsResult = false;
	private boolean entryIsEvaluation = false;
	
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
		
		if(entryIsEvaluation == true) {
			display.clearExpression();
			entryIsEvaluation = false;
		}
		
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
		if((calc.getValue() == display.getEntry() && display.isExpressionEmpty()) || entryIsEvaluation == true) {			
			calc.setValue(display.getEntry());
			
			display.clearExpression();
			display.putEntryInExpression();
			
			display.clearEntry();
		} else {			
			display.putEntryInExpression();
			
			calc.evaluate(display.getEntry());
		}
		
		display.putEvaluatedValueInEntry(calc.getValue());
		display.appendExpressionOperator('=');
		
		entryIsResult = true;
		entryIsEvaluation = true;
		operatorMode = false;
	}

	
	// Called by FXML button
	public void clear() {
		entryIsResult = false;
		entryIsEvaluation = false;
		operatorMode = false;
		
		display.clearEntry();
		display.clearExpression();
		
		calc.reset();
	}
	
	// Called by FXML button
	public void clearEntry() {
	
	}
	
}
