import java.awt.*;

/**
 * A class for a kind of Truck that can transport cars on its flatbed.
 */

public class CarTransporter extends Truck {

    private RampFlatbed rampFlatbed; // The flatbed with a ramp.
    private final int maxWeight = 40000; // The max weight the truck can pull.

    public CarTransporter(Color color,Direction currentDirection) {
        super(500, color, "Car transporter", currentDirection, 593, 255, 18000);
        rampFlatbed = new RampFlatbed(this);
    }

    public CarTransporter(Color color) {
        super(500, color, "Car transporter", 593, 255, 18000);
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
