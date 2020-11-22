package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Display extends VBox {

	@FXML private TextField expression;
	@FXML private TextField value;
	
	public Display() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("display.fxml"));
		fxmlLoader.setRoot(this);		
		fxmlLoader.setClassLoader(getClass().getClassLoader());
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@FXML
	public void processNum() {
		
	}
	
	@FXML
	public void processOperators() {
		
	}
	
}
