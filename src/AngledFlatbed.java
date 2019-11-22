/**
 * Class for an angled flatbed. Has methods for tipping or lowering the flatbed.
 */

public class AngledFlatbed extends Flatbed {
    private Scania parent; // Information from the Scania truck that pulls the flatbed
    private int angle = 0; // The flatbeds angle. Starts at 0.

    public AngledFlatbed(Scania parent) {
        super();
        this.parent = parent;
    }

    //-------------------- METHODS --------------------

    /**
     * Tips the flatbeds angle by 1 degree if the flatbed is within accepted parameters.
     *
     */

    public void tipFlatbed() {
        if (0 <= angle && angle + 1 <= 70 && !parent.isMoving()) {
            angle = getAngle() + 1;
        }
    }

    /**
     * Lowers the flatbeds angle if the flatbed is within accepted parameters.
     *
     */

    public void lowerFlatbed() {
        if (0 <= angle - 1 && angle <= 70 && !parent.isMoving()) {
            angle = getAngle() - 1;
        }
    }


    //-------------------- GETTERS & SETTERS --------------------


    public int getAngle() {
        return angle;
    }
}
