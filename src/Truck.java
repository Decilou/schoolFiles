import java.awt.*;

/**
 * A class for trucks.
 */

public abstract class Truck extends Vehicle {


    public Truck(double enginePower, Color color, String modelName, Direction currentDirection, int length, int width, int weight) {
        super(2, enginePower, color, modelName, currentDirection, length, width, weight);
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
