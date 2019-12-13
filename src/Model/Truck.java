package Model;

import java.awt.*;

/**
 * A class for trucks.
 */

public abstract class Truck extends Vehicle {


    public Truck(double enginePower, Color color, String modelName, Direction currentDirection, int length, int width, int height, int weight, double x, double y) {
        super(2, enginePower, color, modelName, currentDirection, length, width, height, weight,x,y);
    }

    public Truck(double enginePower, Color color, String modelName, int length, int width, int height, int weight, double x, double y) {
        super(2, enginePower, color, modelName, Direction.RIGHT, length, width, height, weight,x,y);
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
