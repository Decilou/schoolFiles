public class AngledFlatbed {
    private Scania parent;
    private int angle = 0;

    public AngledFlatbed(Scania parent) {
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
