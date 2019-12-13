package Model;

import Model.Car;

import java.awt.*;

/**
 * Class for a Saab 95 car.
 */
public class Saab95 extends Car {

    public boolean turboOn;

    public Saab95(Color color, Direction currentDirection, double x, double y) {
        super(4, 125, color, "Model.Saab95", currentDirection, 480, 179, 145, 1495, x, y);
        turboOn = false;
    }

    public Saab95(Color color, double x, double y) {
        super(4, 125, color, "Model.Saab95", 480, 179, 145, 1495, x, y);
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
     *
     * @return speed factor of the car
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void load() {

    }

    @Override
    public void updateTransportable() {

    }

    @Override
    public void placeUnloadedTransportableInWorld() {

    }
}
