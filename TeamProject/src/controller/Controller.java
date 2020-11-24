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
		
		if(entryIsResult == true) {
			display.clearEntry();					
			entryIsResult = false;
		}
		
		if(operatorMode == true) {
			display.clearEntry();					
			operatorMode = false;
		}
		
		display.putEntryDigit(digit);
	}
	
	public void pressOperator(ActionEvent event) {
		OperationStrategy operation = ((OperationButton) event.getSource()).getOperation();	
		operatorMode = true;
		
		if(entryIsEvaluation == true) {
			display.clearExpression();
			entryIsEvaluation = false;
		}
		display.putEntryInExpression();
		display.appendExpressionOperator(operation.getChar());
		
		if(calc.getOperation() == null) {
			calc.setValue(display.getEntry());
			calc.setOperation(operation);
		} else {
			calc.evaluate(display.getEntry());
			display.putEvaluatedValueInEntry(calc.getValue());
			entryIsResult = true;
		}

		// Change the current operation AFTER evaluating the previous operation
		calc.setOperation(operation);
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
		
		//entryIsResult = true;
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
		if(entryIsEvaluation == true) {
			clear();
		} else {
			display.clearEntry();	
		}		
	}
	
}
