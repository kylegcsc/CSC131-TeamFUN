package controller;

import java.io.IOException;
import java.util.Iterator;

import application.OperationStrategy;
import application.OperationStrategyAdd;
import application.OperationStrategyDivide;
import application.OperationStrategyMultiply;
import application.OperationStrategyNegate;
import application.OperationStrategySubtract;
import application.Operations;
import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class OperationButton extends Button {

	private OperationStrategy operationStrategy;
	
	// FXML property set declaratively in the .fxml file
	private final Character operationChar;		
	
	public OperationButton(@NamedArg("operation") Character operationChar) {
		this.operationChar = operationChar;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/calcbutton.fxml"));
		loader.setRoot(this);		
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
		this.setText(Character.toString(operationChar));
		operationStrategy = operationStrategyFromCharacter(operationChar); 
	}
	
	public OperationStrategy getOperation() {
		return operationStrategy;
	}
	
	private static final OperationStrategy operationStrategyFromCharacter(Character operationChar) {
		Iterator<OperationStrategy> it = Operations.iterator();
		while(it.hasNext()) {
			OperationStrategy strategy = it.next();
			if(operationChar.equals(strategy.getChar())) {
				return strategy;
			}
		}
		return null;		
	}
	
}
