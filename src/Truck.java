import java.awt.*;

public abstract class Truck extends Vehicle {



    public Truck(double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection, int length, int width, int weight) {
        super(2, enginePower, currentSpeed, color, modelName, currentDirection, length, width, weight);
    }


    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
