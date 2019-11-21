public class RampFlatbed {
    private CarTransporter parent;
    private OpenableObject rampStatus;

    public RampFlatbed(CarTransporter parent) {
        this.parent = parent;
        rampStatus = OpenableObject.CLOSED;
    }

    public void openRamp(){

        rampStatus = OpenableObject.OPEN;

    }

    public void closeRamp(){

        rampStatus = OpenableObject.CLOSED;

    }

    public OpenableObject getRampStatus() {
        return rampStatus;
    }
}
