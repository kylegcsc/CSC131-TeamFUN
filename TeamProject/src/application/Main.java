package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/main.fxml"));
    	try {
        	loader.load();
    	} catch (IOException e) {
    		throw new RuntimeException(e);
    	}
        primaryStage.setTitle("Team FUN Group Project");
        primaryStage.setScene(new Scene(loader.getRoot()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
