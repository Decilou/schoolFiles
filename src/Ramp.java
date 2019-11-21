public class Ramp {
    private CarTransporter parent;
    private int angle = 90;

    public Ramp(CarTransporter parent) {
        this.parent = parent;
    }

    public void tipFlatbed(int increase){
        if(90 <= angle && angle <= 0 && !parent.isMoving()){ // någon uträckning här kanske? Beroende på hur högt ovanför marken vagnen är.
            angle = getAngle() + increase;
        }

    }

    public void lowerFlatbed(int decrease){
        if(90 <= angle && angle <= 0 && !parent.isMoving()){
            angle = getAngle() - decrease;
        }
    }

    public int getAngle() {
        return angle;
    }
}
