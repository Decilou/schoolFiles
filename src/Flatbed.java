public class Flatbed {
    private Truck parent;
    private int angle;

    public Flatbed(int angle, Truck parent) {
        this.angle = angle;
        this.parent = parent;
    }

    public void tipFlatbed(int increase){
        if(0 <= angle && angle <= 70 && !parent.isMoving()){
            angle = getAngle() + increase;
        }

    }

    public void lowerFlatbed(int decrease){
        if(0 <= angle && angle <= 70 && !parent.isMoving()){
            angle = getAngle() - decrease;
        }
    }

    public int getAngle() {
        return angle;
    }
}
