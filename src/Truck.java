import java.awt.*;

public abstract class Truck extends Vehicle {



    public Truck(double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection) {
        super(2, enginePower, currentSpeed, color, modelName, currentDirection);
    }


    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
