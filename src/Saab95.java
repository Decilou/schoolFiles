import java.awt.*;

/**
 * Class for a Saab 95 car.
 */
public class Saab95 extends Car {

    public boolean turboOn;

    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection, int length, int width, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, currentDirection, length, width, weight);
        turboOn = false;
    }

    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int length, int width, int weight) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, length, width, weight);
        turboOn = false;
    }

    /**
     * Turns the turbo on.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turns the turbo off.
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Calculates and returns speed factor of the car.
     * @return speed factor of the car
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
