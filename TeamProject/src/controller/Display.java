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
	
	public void addExpressionDigit(int digit) {
		StringBuilder builder = new StringBuilder(expression.getText());
		//todo  append whitespace if last character is an operator
		//builder.append(' ');
		builder.append(digit);
		expression.setText(builder.toString());
	}
	
	public void clear() {
		this.expression.setText("");
		this.value.setText("0");
	}
	
	private void updateExpression(String expression) {
		//display an error if expression is too big? or force evaluation? or wrap text?
		this.expression.setText(expression);
	}
	
	private void updateValue(long value) {
		// format in scientific notation etc?
		this.value.setText(Long.toString(value));
	}

	public void clearEntry() {
		this.value.setText("0");		
	}
	
}
