public class RampFlatbed extends Flatbed {
    private CarTransporter parent;
    private OpenableObject rampStatus;

    public RampFlatbed(CarTransporter parent) {
        super();
        this.parent = parent;
        rampStatus = OpenableObject.CLOSED;
    }

    public void openRamp() {
        rampStatus = OpenableObject.OPEN;
    }

    public void closeRamp() {
        rampStatus = OpenableObject.CLOSED;

    }

    public void loadFlatbed(Car car) {
        if (!isMaxWeightReached() || !isMaxLengthReached(car.getLength())) {

        }

    }

    public boolean isMaxWeightReached() {

        return (getWeight() < getMaxLoadingWeight());

    }

    public boolean isMaxLengthReached(int carLength) {

        return (carLength+getLength() >)
    }


    public OpenableObject getRampStatus() {
        return rampStatus;
    }
}
