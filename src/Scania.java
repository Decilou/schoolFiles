import java.awt.*;

/**
 * a class for Scania trucks.
 */

public class Scania extends Truck {

    private AngledFlatbed angledFlatbed; //The flatbed that can change angle.
    private final int maxWeightToPull = 40000; // The max weight the truck can pull.

    public Scania(Color color, Direction currentDirection) {
        super(500, color, "Scania", currentDirection, 593, 255, 18000);
        angledFlatbed = new AngledFlatbed(this);
    }

    public Scania(Color color) {
        super(500, color, "Scania", 593, 255, 18000);
        angledFlatbed = new AngledFlatbed(this);
    }


    /**
     * A method for moving the truck when it can move, witch is dependent on the angle of the flatbed.
     */

    //TODO: Delegering av tipFlatbed och lowerFlatbed. -> Flatbed. Bli av med dubbelberoende mellan Scania <-> AngledFlatbed.
    @Override
    public void move() {
        if (angledFlatbed.getAngle() == 0 && angledFlatbed.getCurrentLoadedWeight() + angledFlatbed.getWeight() <= maxWeightToPull) {
            super.move();
        } else if (angledFlatbed.getCurrentLoadedWeight() + angledFlatbed.getWeight() > maxWeightToPull) {
            System.out.println("Cannot pull flatbed, it is too heavy!");
        } else {
            System.out.println("Cannot move when flatbed is up!");
        }
    }

    /**
     * Delegation of tipping flatbed to the flatbed.
     */
    public void tipFlatbed() {
        if (!this.isMoving()) {
            angledFlatbed.tipFlatbed();
        }
    }

    /**
     * Delegation of lowering flatbed to the flatbed.
     */
    public void lowerFlatbed() {
        if (!this.isMoving()) {
            angledFlatbed.lowerFlatbed();
        }
    }

    //-------------------- GETTERS & SETTERS --------------------

    public int getMaxWeightToPull() {
        return maxWeightToPull;
    }
}
