package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Display extends VBox {
	
	@FXML private Label expression;
	@FXML private Label value;
	
	public Display() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/display.fxml"));
		loader.setRoot(this);		
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void addExpressionDigit(int digit) {
		StringBuilder builder = new StringBuilder(expression.getText());
		//todo  append whitespace if last character is an operator
		//builder.append(' ');
		builder.append(digit);
		expression.setText(builder.toString());
	}
	
	private void addValueDigit(int digit) {
		String valueText = value.getText();
		if(valueText.equals("0")) {
			valueText = "";
		}
		StringBuilder builder = new StringBuilder(valueText);
		builder.append(digit);
		value.setText(builder.toString());
	}
	
	public void putDigit(int digit) {
		// dont put value into expression text until an operation is pressed
		//addExpressionDigit(digit);
		addValueDigit(digit);
	}
	
	public void clear() {
		this.expression.setText("");
		this.value.setText("0");
	}
	
	private void updateExpression(String expression) {
		//display an error if expression is too big? or force evaluation? or wrap text?
		this.expression.setText(expression);
	}
	
	private void updateValue(double value) {
		// format in scientific notation etc?
		this.value.setText(Double.toString(value));
	}

	public void clearEntry() {
		this.value.setText("0");		
	}
	
}
