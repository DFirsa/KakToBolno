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
import javafx.scene.layout.Pane;
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

    @FXML
    Pane canvas;

    double firstLengthVal = 0;
    double secondLengthVal = 0;
    double firstMassVal = 0;
    double secondMassVal = 0;
    double startAngleVal = 0;

    boolean cathSmth = false;
    boolean buttonIsPushed = false;
    boolean isUpdate = true;

    boolean cont(double[] data){
        for (double v: data){
            if (v == 0)return true;
        }
        return false;
    }

    @FXML
    void initialize() {

        runButton.setOnAction(event -> {

            try{

                firstLengthVal = Double.valueOf(firstLength.getText());
                secondLengthVal = Double.valueOf(secondLength.getText());
                firstMassVal = Double.valueOf(firstMass.getText());
                secondMassVal = Double.valueOf(secondMass.getText());
                startAngleVal = Double.valueOf(startAngle.getText());

                double[] container = {firstLengthVal, secondLengthVal, firstMassVal, secondMassVal, startAngleVal};
                if (cont(container)) cathSmth = true;

            } catch (java.lang.NumberFormatException e){ cathSmth = true; }

            if (!cathSmth){
                buttonIsPushed = true;
                isUpdate = false;
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("INPUT ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Enter all input parameters as float values.");

                alert.showAndWait();
            }

        });
    }
}
