package sample;

import java.awt.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    Pane canvas;

    @FXML
    private Slider firstAngle;

    @FXML
    private Slider mass;

    @FXML
    private Slider secondAngle;

    @FXML
    private Label secondAngleOut;

    @FXML
    private Button runButton;

    @FXML
    private Label firstAngleOut;

    @FXML
    private Label massOut;

//    double firstLengthVal = 0;
//    double secondLengthVal = 0;
//    double firstMassVal = 0;
//    double secondMassVal = 0;
//    double startAngleVal = 0;

    double firstAngleVal = 0;
    double secondAngleVal = 0;
    double massVal = 0;


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

        mass.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                massOut.textProperty().setValue(String.format("%.3f", mass.getValue()));
            }
        });

        firstAngle.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                firstAngleOut.textProperty().setValue(String.format("%.3f", firstAngle.getValue()));
            }
        });

        secondAngle.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                secondAngleOut.textProperty().setValue(String.format("%.3f", secondAngle.getValue()));
            }
        });

        runButton.setOnAction(event -> {

            try{

                firstAngleVal = firstAngle.getValue();
                secondAngleVal = secondAngle.getValue();
                massVal = mass.getValue();

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

            cathSmth = false;

        });
    }
}
