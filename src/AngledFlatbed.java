/**
 * Class for a kind of flatbed.
 */

public class AngledFlatbed extends Flatbed {
    private Scania parent; // Information from the Scania truck that pulls the flatbed
    private int angle = 0; // The flatbeds angle. Starts at 0.

    public AngledFlatbed(Scania parent) {
        super();
        this.parent = parent;
    }

    /**
     * Tips the flatbeds angle if the flatbed is within accepted parameters.
     * @param increase
     */

    public void tipFlatbed(int increase){
        if(0 <= angle && angle <= 70 && !parent.isMoving()){
            angle = getAngle() + increase;
        }

    }

    /**
     * Lowers the flatbeds angle if the flatbed is within accepted parameters.
     * @param decrease
     */

    public void lowerFlatbed(int decrease){
        if(0 <= angle && angle <= 70 && !parent.isMoving()){
            angle = getAngle() - decrease;
        }
    }


    //-------------------- GETTERS & SETTERS --------------------


    public int getAngle() {
        return angle;
    }
}
