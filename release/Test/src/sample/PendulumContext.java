package sample;

import javafx.scene.layout.Pane;

public class PendulumContext {

   private double radKoef = Math.PI / 180;
   private double t = 0;
   private boolean isSimilating = false;

   private final double G = 9.81;

   private double Length = 1;
   private double D = 1;
   private double Mass = 1;

   private double a1 = 0;
   private double a2 = 0;

   private double angle1 = 0;
   private double angle2 = 0;

   private double omega1 = 0;
   private double omega2 = 0;

   private Drawing drawing;

    PendulumContext(double angle, Pane canvas){
        drawing = new Drawing(canvas);
        angle1 = -angle * radKoef;
    }

    void calculation(){
        omega1 = Math.sqrt(G / Length);
        omega2 = Math.sqrt(G / Length + 2 * D * Mass);
        a1 = (angle1 + angle2) / 2.0;
        a2 = (angle1 + angle2) / 2.0;
    }

    void tick(double delta){
        if (isSimilating){
            t += delta;
            double cos1 = Math.cos(omega1 * t);
            double cos2 = Math.cos(omega2 * t);

            angle1 = a1 * cos1 + a2 * cos2;
            angle2 = a1 * cos1 - a2 * cos2;
        }
        drawing.redraw(angle1, angle2);
    }

    void startSimulation(){
        isSimilating = true;
        t = 0;
        calculation();
    }

    void stopSimulation(){
        isSimilating = false;
    }

    void restartSimaulation(){
        stopSimulation();
        startSimulation();
    }

}
