package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("sample.fxml").openStream());
        Controller controller = (Controller) fxmlLoader.getController();

        primaryStage.setTitle("Pendulums animation");
        primaryStage.setScene(new Scene(p, 789, 489));


        primaryStage.show();
        primaryStage.setResizable(false);

        PendulumContext context = new PendulumContext(controller.canvas);

        long step  = 16L;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(step),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!controller.isUpdate){
                            controller.isUpdate = true;
                            context.setData(controller.firstMassVal,1,controller.startAngleVal,0);
                            context.restartSimaulation();
                        }

                        context.tick((double) step / 1000);
                    }
                }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }


    public static void main(String[] args) {
        launch(args);

    }
}
