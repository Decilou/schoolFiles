import java.awt.*;

/**
 * A class for a kind of Truck that can transport cars.
 */

public class CarTransporter extends Truck {

    private RampFlatbed rampFlatbed; // The flatbed with a ramp.
    private final int maxWeight = 40000; // The max weight the truck can pull.

    public CarTransporter(double enginePower, Color color, String modelName, Direction currentDirection, int length, int width, int weight) {
        super(enginePower, color, modelName, currentDirection, length, width, weight);
        rampFlatbed = new RampFlatbed(this);
    }


    /**
     * A method for moving the transporter when it can move, witch is when the ramp is closed.
     */

    @Override
    public void move() {
        if (rampFlatbed.getRampStatus() == OpenStatus.CLOSED && rampFlatbed.getCurrentLoadedWeight() + rampFlatbed.getWeight() <= maxWeight) {
            super.move();
        } else if (rampFlatbed.getCurrentLoadedWeight() + rampFlatbed.getWeight() > maxWeight) {
            System.out.println("Cannot pull flatbed, it is too heavy!");
            throw new IllegalCallerException("Cannot pull flatbed, it is too heavy.");
        } else {
            System.out.println("Cannot move when the ramp is down!");
            throw new IllegalCallerException("Cannot move when the ramp is down.");
        }
    }

}
