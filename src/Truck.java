import java.awt.*;

/**
 * A class for trucks.
 */

public abstract class Truck extends Vehicle {


    public Truck(double enginePower, Color color, String modelName, Direction currentDirection, int length, int width, int height, int weight) {
        super(2, enginePower, color, modelName, currentDirection, length, width, height, weight);
    }

    public Truck(double enginePower, Color color, String modelName, int length, int width, int height, int weight) {
        super(2, enginePower, color, modelName, Direction.RIGHT, length, width, height, weight);
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
