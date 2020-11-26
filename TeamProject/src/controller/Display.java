package controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
		this.entry.setText(formatValue(value));
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
		builder.append(formatValue(getEntry()));
		expression.setText(builder.toString());
	}
	
	public void appendEntryDecimal() {
		// don't append a decimal if the entry already has a decimal
		if(entry.getText().contains(".")) return;
		
		StringBuilder builder = new StringBuilder(entry.getText());
		builder.append('.');	
		entry.setText(builder.toString());
	}
	
	public double getEntry() {
		return Double.parseDouble(entry.getText());
	}
	
	public boolean isEntryEmpty() {
		if(entry.getText().equals("0.0") || entry.getText().equals("0")) return true;
		return false;
	}
	
	public boolean isExpressionEmpty() {
		return (expression.getText().isEmpty());
	}
	
	public void clearEntry() {
		this.entry.setText("0");
	}
	
	public void clearExpression() {
		this.expression.setText("");
	}
	
	private boolean isWholeNumber(double value) {
		return value % (double) 1.0 == (double) 0.0;
	}
	
	private String formatValue(double value) {
		String formatted = Double.toString(value);
		if(isWholeNumber(value)) {
			formatted = formatted.substring(0, formatted.length()-2);
		} else {
			return new DecimalFormat("0.0#########").format(value);
		}
		return formatted;
	}

	public void putEntryNegated()
	{
	   this.entry.setText(""+(-Integer.parseInt(this.entry.getText())));
	   expression.setText(this.entry.getText());
	}

	public String getExpression()
	{
		return expression.getText().toString();
	}
	
}
