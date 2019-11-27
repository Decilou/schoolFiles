import java.awt.*;
import java.util.Deque;

/**
 * A class for a kind of Truck that can transport cars on its flatbed.
 */

public class CarTransporter extends Truck {

    private RampFlatbed rampFlatbed; // The flatbed with a ramp.
    private final int maxWeightToPull = 40000; // The max weight the truck can pull.

    public CarTransporter(Color color,Direction currentDirection) {
        super(500, color, "Car transporter", currentDirection, 593, 255, 18000);
        rampFlatbed = new RampFlatbed();
    }

    public CarTransporter(Color color) {
        super(500, color, "Car transporter", 593, 255, 18000);
        rampFlatbed = new RampFlatbed();
    }

    public void openRamp() {
        if (!this.isMoving()) {
            rampFlatbed.openRamp();
        } else {
            System.out.println("Truck is moving! Cannot open ramp!");
        }
    }

    public void closeRamp() {
        if (!this.isMoving()) {
            rampFlatbed.closeRamp();
        } else {
            System.out.println("Truck is moving! Cannot close ramp!");
        }
    }

    // TODO: Fundera lite över hur vi kan abstrahera detta upp till överliggande classer.
    public void updatePositionForCarsInStack() {
        Deque<Car> stack = rampFlatbed.getLoadedCarsStack();

        for (Car c: stack){
            c.updateTransportedVehicle(this);
        }
    }


    /**
     * A method for moving the transporter when it can move, witch is when the ramp is closed.
     */


    @Override
    public void move() {
        if (rampFlatbed.getRampStatus() == OpenStatus.CLOSED && rampFlatbed.getCurrentLoadedWeight() + rampFlatbed.getWeight() <= maxWeightToPull) {
            super.move();
        } else if (rampFlatbed.getCurrentLoadedWeight() + rampFlatbed.getWeight() > maxWeightToPull) {
            System.out.println("Cannot pull flatbed, it is too heavy!");
        } else {
            System.out.println("Cannot move when the ramp is down!");
        }
    }

    //TODO: delegering av unloading och loading?
    public void unloadObjectFromFlatbed(Car car) {
        rampFlatbed.unloadObjectFromFlatbed();


    }

    public RampFlatbed getRampFlatbed() {
        return rampFlatbed;
    }

    public int getMaxWeightToPull() {
        return maxWeightToPull;
    }
}
