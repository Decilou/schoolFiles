import java.awt.*;

/**
 * Class for Volvo 240.
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    public Volvo240(Color color, Direction currentDirection) {
        super(4, 100, color, "Volvo240", currentDirection, 482, 171, 145, 1950);
    }

    public Volvo240(Color color) {
        super(4, 100, color, "Volvo240",482, 171, 145, 1950);
    }


    /**
     * Calculates and returns the speed factor.
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
