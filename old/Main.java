package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        Pendulum first = new Pendulum(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.35,
                                        Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2,
                                        1, Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.7*(2/3),
                                        100 ,Math.PI/6);
        Pendulum second = new Pendulum(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.35,
                                        Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2,
                                        2,Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.7*(1/3),
                                        100,0);

        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
                                        Toolkit.getDefaultToolkit().getScreenSize().getHeight(),
                                        Color.ANTIQUEWHITE);

        Circle PendulumBall_1 = new Circle(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/50,
                                            Color.BLUE);
        PendulumBall_1.relocate(first.getxCenter()
                                + first.getLengthFull() * Math.cos(Math.PI/2 - first.getAngle()),
                                first.getyCenter() + first.getLengthFull()*Math.sin(Math.PI/2 - first.getAngle()));



        Circle PendulumBall_2 = new Circle(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/50,
                                            Color.BLUEVIOLET);
        PendulumBall_2.relocate(second.getxCenter()
                                + second.getLengthFull() * Math.cos(Math.PI/2 - second.getAngle()),
                                second.getyCenter() + second.getLengthFull()*Math.sin(Math.PI/2 - second.getAngle()));

        canvas.getChildren().add(PendulumBall_1);
        canvas.getChildren().add(PendulumBall_2);

        Line boarder = new Line();
        boarder.setStartX(Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.7);
        boarder.setStartY(0);
        boarder.setEndX(Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.7);
        boarder.setEndY(Toolkit.getDefaultToolkit().getScreenSize().getHeight());

        canvas.getChildren().add(boarder);

//        System.out.print(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/50);
        System.out.print(second.getxCenter());

//        Line PendulumLine_1 = new Line();
//
//        Line PendulumLine_2 = new Line();


        stage.setTitle("Connected pendulums animation");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
