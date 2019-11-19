import java.awt.*;


/**
 * Class for a car. Has methods to start/stop engine, gas, brake.
 */
public abstract class Car extends Vehicle {

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, currentDirection);
    }

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors,enginePower,currentSpeed,color,modelName,Direction.RIGHT);
    }
}
