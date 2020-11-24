package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Display extends VBox {
	
	@FXML private Label expression;
	@FXML private Label entry;
	
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
	
	public void putEvaluatedValueInEntry(double value) {
		this.entry.setText(Double.toString(value));
	}
	
	public double getEntry() {
		return Double.parseDouble(entry.getText());
	}
	
	public void putEntryDigit(int digit) {
		if(isEntryEmpty()) {
			entry.setText(Integer.toString(digit));
		} else {
			StringBuilder builder = new StringBuilder(entry.getText());
			builder.append(digit);
			entry.setText(builder.toString());	
		}		
	}
	
	public void appendExpressionValue(double value) {
		StringBuilder builder = new StringBuilder(expression.getText());
		builder.append(Double.toString(value));
		expression.setText(builder.toString());
	}
	
	public void appendExpressionOperator(char operator) {
		StringBuilder builder = new StringBuilder(expression.getText());
		builder.append(' ').append(operator).append(' ');	
		expression.setText(builder.toString());
	}
	
	public void putEntryInExpression() {
		StringBuilder builder = new StringBuilder(expression.getText());
		builder.append(entry.getText());
		expression.setText(builder.toString());
	}
	
	public boolean isEntryEmpty() {
		if(entry.getText().equals("0.0") || entry.getText().equals("0")) return true;
		return false;
	}
	
	public void clearEntry() {
		this.entry.setText("");
	}
	
	public void clearExpression() {
		this.expression.setText("");
	}
	
//	
//	public void setEntry(double entry) {
//		value.setText(Double.toString(entry));
//	}
//	
//	public void putExpressionValue(double value) {
//		StringBuilder builder = new StringBuilder(expression.getText());
//		//todo  append whitespace if last character is an operator
//		//builder.append(' ');
//		builder.append(Double.toString(value));
//		expression.setText(builder.toString());
//	}
//	
//	private void addExpressionDigit(int digit) {
//		StringBuilder builder = new StringBuilder(expression.getText());
//		//todo  append whitespace if last character is an operator
//		//builder.append(' ');
//		builder.append(digit);
//		expression.setText(builder.toString());
//	}
//	
//	private void addValueDigit(int digit) {
//		String valueText = value.getText();
//		if(valueText.equals("0.0")) {
//			valueText = "";
//		}
//		StringBuilder builder = new StringBuilder(valueText);
//		builder.append(digit);
//		value.setText(builder.toString());
//	}
//	
//	public void putOperator(String operator) {
//		StringBuilder builder = new StringBuilder(expression.getText());
//		builder.append(operator);
//		builder.append(" ");
//		expression.setText(builder.toString());
//	}
//	
//	public void putDigit(int digit) {
//		// dont put value into expression text until an operation is pressed
//		//addExpressionDigit(digit);
//		addValueDigit(digit);
//	}
//	
//	public void clear() {
//		this.expression.setText("");
//		this.value.setText("0.0");
//	}
//	
//	private void updateExpression(String expression) {
//		//display an error if expression is too big? or force evaluation? or wrap text?
//		this.expression.setText(expression);
//	}
//	
//	private void updateValue(double value) {
//		// format in scientific notation etc?
//		this.value.setText(Double.toString(value));
//	}
//
//	public double getEntry() {
//		double entry = Double.parseDouble(value.getText());
//		return entry;
//	}
//	
//	public void clearEntry() {
//		this.value.setText("0.0");
//	}
	
}
