package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Drawing {

    private Pane canvas;

    private Circle ball1;
    private Circle ball2;
    private Line line1;
    private Line line2;
    private Line spring;

    private Rectangle basePoint1;
    private Rectangle basePoint2;

    private final double basePoint1X = 300;
    private final double basePoint2X = 400;
    private final double basePointsY = 100;

    private double length = 200;
    private boolean added = false;

    Drawing(Pane canvas){
        this.canvas = canvas;

        ball1 = new Circle(20, Color.BLUE);
        ball2 = new Circle(20, Color.RED);

        line1 = new Line();
        line2 = new Line();
        spring = new Line();

        spring.setStroke(Color.color(0.25, 1, 0.65));

        basePoint1 = new Rectangle();
        basePoint2 = new Rectangle();

        basePoint1.setX(basePoint1X);
        basePoint2.setX(basePoint2X);
        basePoint1.setY(basePointsY);
        basePoint2.setY(basePointsY);

        basePoint1.setHeight(20);
        basePoint1.setWidth(20);
        basePoint2.setHeight(20);
        basePoint2.setWidth(20);

        line1.setStartX(basePoint1X);
        line2.setStartX(basePoint2X);
        line1.setStartY(basePointsY);
        line2.setStartY(basePointsY);


//        canvas.getChildren().add(ball1);
//        canvas.getChildren().add(ball2);
//        canvas.getChildren().add(basePoint1);
//        canvas.getChildren().add(basePoint2);
//        canvas.getChildren().add(line1);
//        canvas.getChildren().add(line2);
//        canvas.getChildren().add(spring);
    }

    void redraw(double angle1, double angle2){

        ball1.setLayoutX(basePoint1X + Math.cos(Math.PI/2 - angle1)*length);
        ball2.setLayoutX(basePoint2X + Math.cos(Math.PI/2 - angle2)*length);
        ball1.setLayoutY(basePointsY + Math.sin(Math.PI/2 - angle1)*length);
        ball1.setLayoutY(basePointsY + Math.sin(Math.PI/2 - angle2)*length);

        line1.setEndX(basePoint1X + Math.cos(Math.PI/2 - angle1)*(length-20));
        line2.setEndX(basePoint2X + Math.cos(Math.PI/2 - angle2)*(length-20));
        line1.setEndY(basePointsY + Math.sin(Math.PI/2 - angle1)*(length-20));
        line2.setEndY(basePointsY + Math.sin(Math.PI/2 - angle2)*(length-20));

        spring.setStartX(ball1.getCenterX());
        spring.setStartY(ball1.getCenterY());
        spring.setEndY(ball2.getCenterY());
        spring.setEndX(ball2.getCenterX());

        if (!added) {
            canvas.getChildren().add(ball1);
            canvas.getChildren().add(ball2);
            canvas.getChildren().add(basePoint1);
            canvas.getChildren().add(basePoint2);
            canvas.getChildren().add(line1);
            canvas.getChildren().add(line2);
            canvas.getChildren().add(spring);

            added = true;
        }
    }

}
