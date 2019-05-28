package sample;

public class Pendulum {

    private double lengthCommon;
    private double lengthFull;
    private double weight;
    private double angle;

    private double xCenter;
    private double yCenter;

    final double g = 9.8;

    public Pendulum(double lengthCommon, double lengthFull , double weight, double xCenter, double yCenter,
                    double startAngle){

        this.lengthCommon = lengthCommon;
        this.lengthFull = lengthFull;
        this.weight = weight;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.angle = startAngle;

    }

    //TODO sold system of equations
    public void findAlphaFrom1(final double k, Pendulum another){

        angle = another.angle + ( (g * another.angle) / (k * Math.pow(lengthCommon,2) )) -
                ((g * another.angle) / (k * Math.pow(lengthCommon,2) * another.lengthFull));
    }

    public double getAngle() {
        return angle;
    }

    public double getLengthCommon() {
        return lengthCommon;
    }

    public double getLengthFull() {
        return lengthFull;
    }

    public double getWeight() {
        return weight;
    }

    public double getxCenter() {
        return xCenter;
    }

    public double getyCenter() {
        return yCenter;
    }
}
