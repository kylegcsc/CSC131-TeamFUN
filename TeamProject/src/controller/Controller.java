package controller;

import application.Calculator;
import application.OperationStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
	
	// flag for if an operator was pressed, used to determine if entry needs to be wiped when pressing next digit
	private boolean operatorMode = false;
	
	// is the current entry the result of an operation? (as opposed to a user entered digit)
	private boolean entryIsResult = false;
	
	// is the current entry the result of an evaluation? (= button)
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
		
		// If we are still in operator mode, the user hasn't entered any digits into entry
		// so this adds support for swapping the current operator if the user misclicks
		if(operatorMode == true) {
			calc.setOperation(operation);
			display.swapOperator(operation.getChar());
			return;
		}
		
		operatorMode = true;
		
		// If the current entry result of an evaluation then start a new expression
		if(entryIsEvaluation == true) {
			display.clearExpression();
		}
		
		//Used for the negation operation
		if(((OperationButton)event.getSource()).getOperation().getChar() == '±') {						
			display.putEntryNegated();
			if(entryIsEvaluation == true) {
				evaluate();
			}
			return;
		}
		
		display.putEntryInExpression();
		display.appendExpressionOperator(operation.getChar());
		
		// If the current entry was the result of an evaluation then it is the LHS for next calculator operation
		if(calc.getOperation() == null || entryIsEvaluation == true) {
			calc.setValue(display.getEntry());
			calc.setOperation(operation);
		} else { // otherwise this is the next operation in a series of operators, so evaluate the previous operation
			calc.evaluate(display.getEntry());
			display.putEvaluatedValueInEntry(calc.getValue());
			entryIsResult = true;
		}
		
		// the entry is no longer an evaluation, it is now an operation result
		if(entryIsEvaluation == true) {
			entryIsEvaluation = false;
		}

		// Change the current operation AFTER evaluating the previous operation
		calc.setOperation(operation);
	}
	
	// Called by FXML button
	public void pressDecimal(ActionEvent event) {
		if(entryIsEvaluation == true) {
			display.clearExpression();
			display.clearEntry();
		}
		
		if(operatorMode == true) {
			display.clearEntry();
			entryIsEvaluation = false;
			entryIsResult = false;
			operatorMode = false;			
		}
		
		display.appendEntryDecimal();
	}
	
	public void evaluate() {
		// Identity if there is no expression
		if((calc.getValue() == display.getEntry() && display.isExpressionEmpty()) || entryIsEvaluation == true) {			
			calc.setValue(display.getEntry());
			
			display.clearExpression();
			display.putEntryInExpression();
			
			//display.clearEntry();
		} else {
			display.putEntryInExpression();
			
			calc.evaluate(display.getEntry());
		}
		
		display.putEvaluatedValueInEntry(calc.getValue());
		display.appendExpressionOperator('=');
		
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
		// If the current entry was the result of an evaluation, start a new expression
		if(entryIsEvaluation == true) {
			clear();
		} else {
			display.clearEntry();
		}		
	}
	
}
