package controller;

import java.io.IOException;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class DigitButton extends Button {

	private final int digit;
	
	public DigitButton(@NamedArg("digit") int digit) {
		this.digit = digit;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/calcbutton.fxml"));
		loader.setRoot(this);		
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
		this.setText(Integer.toString(digit));
	}
	
	public int getDigit() {
		return digit;
	}

}
