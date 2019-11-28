import java.awt.*;


/**
 * Class for a car. Has methods to start/stop engine, gas, brake.
 */
public abstract class Car extends Vehicle {

    public Car(int nrDoors, double enginePower, Color color, String modelName, Direction currentDirection, int length, int width, int height, int weight) {
        super(nrDoors, enginePower, color, modelName, currentDirection, length, width, height, weight);
    }

    public Car(int nrDoors, double enginePower, Color color, String modelName, int length, int width, int height, int weight) {
        super(nrDoors, enginePower, color, modelName, Direction.RIGHT, length, width, height, weight);
    }
}
