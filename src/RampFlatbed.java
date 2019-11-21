public class RampFlatbed extends Flatbed {
    private CarTransporter parent;
    private OpenableObject rampStatus;
    private int currentLoadedLength;
    private int maxLoadedLength;

    public RampFlatbed(CarTransporter parent) {
        super();
        this.parent = parent;
        maxLoadedLength = getLength();
        rampStatus = OpenableObject.CLOSED;
    }

    public void openRamp() {
        rampStatus = OpenableObject.OPEN;
    }

    public void closeRamp() {
        rampStatus = OpenableObject.CLOSED;
    }

    public void loadFlatbed(Car car) {
        if (isObjectLoadable(car)){
            //Load the car and update all.
        }
    }

    private boolean isObjectLoadable(Car car){
        return !(isMaxLengthReached(car.getLength()) || isMaxWeightReached(car.getWeight()) || isMaxWidthReached(car.getWidth()));
    }

    private boolean isMaxWeightReached(int objectWeight) {
        return (objectWeight + getCurrentLoadedWeight() <= getMaxLoadableWeight());
    }

    private boolean isMaxLengthReached(int objectLength) {
        return (objectLength + currentLoadedLength + 10 >= maxLoadedLength);
    }

    private boolean isMaxWidthReached(int objectWidth){
        return (objectWidth >= this.getWidth());
    }

    public OpenableObject getRampStatus() {
        return rampStatus;
    }
}