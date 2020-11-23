package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Display extends VBox {
	
	@FXML private Label expressionText;
	@FXML private Label valueText;
	
	public Display() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/display.fxml"));
		fxmlLoader.setRoot(this);		
		fxmlLoader.setClassLoader(getClass().getClassLoader());
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		//this.getStyleClass().add("display");
	}
	
	public void addExpressionDigit(int digit) {		
		StringBuilder builder = new StringBuilder(expressionText.getText());
		builder.append(' ');
		builder.append(digit);
		expressionText.setText(builder.toString());
	}
	
	private void updateExpression(String expression) {
		//display an error if expression is too big? or force evaluation? or wrap text?
		expressionText.setText(expression);
	}
	
	private void updateValue(long value) {
		// format in scientific notation etc?
		valueText.setText(Long.toString(value));
	}
	
}
