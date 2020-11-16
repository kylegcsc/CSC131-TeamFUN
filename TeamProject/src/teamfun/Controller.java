package teamfun;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

public class Controller {

	    @FXML
	    private Button btn4;

	    @FXML
	    private Button btn5;

	    @FXML
	    private Button btnClr;

	    @FXML
	    private Button btn9;

	    @FXML
	    private Button btn8;

	    @FXML
	    private Button btn7;

	    @FXML
	    private Button btn3;

	    @FXML
	    private Button btn2;

	    @FXML
	    private Button btn1;

	    @FXML
	    private Button btnEqual;

	    @FXML
	    private Button btnMRemove;

	    @FXML
	    private Button btnMAdd;
	    @FXML
	    private TextField screenPrmpt;


    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        screenPrmpt.setStyle("-fx-text-inner-color: green; -fx-font-size: 16px;");
		screenPrmpt.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }
}
