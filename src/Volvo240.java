import java.awt.*;

/**
 * Class for Volvo 240.
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }

    /**
     * Calculates and returns the speed factor.
     * @return speed factor of the car
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


}
