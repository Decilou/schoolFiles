import java.awt.*;

//TODO: Add that the car knows it's loaded. If loaded, stopEngine. Block start engine if loaded. Method for updating x, y.

/**
 * Class for a car. Has methods to start/stop engine, gas, brake.
 */
public abstract class Car extends Vehicle {

    public Car(int nrDoors, double enginePower, Color color, String modelName, Direction currentDirection, int length, int width, int weight) {
        super(nrDoors, enginePower, color, modelName, currentDirection, length, width, weight);
    }

    public Car(int nrDoors, double enginePower, Color color, String modelName, int length, int width, int weight) {
        super(nrDoors,enginePower,color,modelName,Direction.RIGHT, length, width, weight);
    }
}
