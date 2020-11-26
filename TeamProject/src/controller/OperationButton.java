package controller;

import java.io.IOException;

import application.OperationStrategy;
import application.OperationStrategyAdd;
import application.OperationStrategyDivide;
import application.OperationStrategyMultiply;
import application.OperationStrategyNegate;
import application.OperationStrategySubtract;
import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class OperationButton extends Button {

	private OperationStrategy operationStrategy;
	
	// FXML property set declaratively in the .fxml file
	private final String operation;		
	
	public OperationButton(@NamedArg("operation") String operation) {
		this.operation = operation;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/calcbutton.fxml"));
		loader.setRoot(this);		
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
		this.setText(operation);
		operationStrategy = operationPropertyToStrategy(operation); 
	}
	
	public OperationStrategy getOperation() {
		return operationStrategy;
	}
	
	public final String getOperationString() {
		return operation;
	}
	
	private static final OperationStrategy operationPropertyToStrategy(String operation) {
		switch(operation) {
		case "+":
			return new OperationStrategyAdd();
		case "-":
			return new OperationStrategySubtract();
		case "/":
			return new OperationStrategyDivide();
		case "x":
			return new OperationStrategyMultiply();	
		case "±":
			return new OperationStrategyNegate();
		}
		// todo throw an exception if the property in the fxml is not set properly
		return null;
	}

}
