import java.awt.*;

/**
 * Class for Volvo 240.
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection, int length, int width, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, currentDirection, length, width, weight);
    }

    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int length, int width, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName,length, width, weight);
    }



    /**
     * Calculates and returns the speed factor.
     * @return speed factor of the car
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


}
