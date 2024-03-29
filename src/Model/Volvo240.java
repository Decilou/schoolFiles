package Model;

import java.awt.*;

/**
 * Class for Volvo 240.
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(Color color, Direction currentDirection, double x, double y) {
        super(4, 100, color, "Volvo240", currentDirection, 482, 171, 145, 1950, x, y);
    }

    public Volvo240(Color color, double x, double y) {
        super(4, 100, color, "Volvo240", 482, 171, 145, 1950, x, y);
    }


    /**
     * Calculates and returns the speed factor.
     *
     * @return speed factor of the car
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
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
