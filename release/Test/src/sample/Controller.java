package sample;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

import javax.swing.*;

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

    private double firstLengthVal = 0;
    private double secondLengthVal = 0;
    private double firstMassVal = 0;
    private double secondMassVal = 0;
    private double startAngleVal = 0;

    private boolean cathSmth = false;

    @FXML
    void initialize() {
        runButton.setOnAction(event -> {
            System.out.println("getValues: ");

            try{

                firstLengthVal = Double.valueOf(firstLength.getText());
                secondLengthVal = Double.valueOf(secondLength.getText());
                firstMassVal = Double.valueOf(firstMass.getText());
                secondMassVal = Double.valueOf(secondMass.getText());
                startAngleVal = Double.valueOf(startAngle.getText());

            } catch (java.lang.NumberFormatException e){

                cathSmth = true;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("ENTER ALL INPUT PARAMETERS");

                alert.showAndWait();
            }

            if (!cathSmth){

            }

        });
    }
}
