package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class CalculatorButton extends Button {

	public CalculatorButton() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/calcbutton.fxml"));
		loader.setRoot(this);		
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
	}
	
}
