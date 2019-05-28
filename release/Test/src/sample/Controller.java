package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstLength;

    @FXML
    private TextField startAngle;

    @FXML
    private TextField secondLength;

    @FXML
    private TextField secondMass;

    @FXML
    private Button runButton;

    @FXML
    private TextField firstMass;

    @FXML
    void initialize() {
        runButton.setOnAction(event -> {
            System.out.println("get");
        });
    }
}
