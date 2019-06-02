package sample;

import javafx.scene.layout.Pane;

public class PendulumContext {

    double radKoef = Math.PI / 180;
    double t = 0;
    boolean isSimulating = false;

    final double G = 9.81;

    double Length = 1;
    double D = 1;
    double Mass = 1;

    double a1 = 0;
    double a2 = 0;

    double angle1 = 0;
    double angle2 = 0;

    double omega1 = 0;
    double omega2 = 0;

    Drawing drawing;

    PendulumContext(Pane canvas){
        drawing = new Drawing(canvas);
    }

//    void setData(double mass, double length1, double angle1, double angle2){
//        Mass = mass;
//        Length = length1;
//        this.angle1 = -angle1*radKoef;
//        this.angle2 = angle2*radKoef;
//    }

    void setData(double angle1, double angle2, double mass){
        Mass = mass;
        this.angle1 = -angle1*radKoef;
        this.angle2 = angle2*radKoef;
    }

    void calculation(){
        omega1 = Math.sqrt(G / Length + 2);
        omega2 = Math.sqrt(G / Length + 2 * D * Mass);
        a1 = (angle1 + angle2) / 2.0;
        a2 = (angle1 -  angle2) / 2.0;
    }

    void startSimulation(){
        isSimulating = true;
        t = 0;
        calculation();
    }

    void stopSimulation(){
        isSimulating = false;
    }

    void restartSimaulation(){
        stopSimulation();
        startSimulation();
    }

    void tick(double delta){
        if(isSimulating){
            t += delta;
            double cos1 = Math.cos(omega1 * t);
            double cos2 = Math.cos(omega2 * t);
            angle1 = a1 * cos1 + a2 * cos2;
            angle2 = a1 * cos1 - a2 * cos2;
        }
       drawing.redraw(angle1, angle2);
    }

}
