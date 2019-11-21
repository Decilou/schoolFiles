import java.util.ArrayDeque;
import java.util.Deque;

/*TODO: Method for unloading car.
TODO: Loaded car's position is according to CarTransporter if loaded.
 */

public class RampFlatbed extends Flatbed {
    private CarTransporter parent;
    private OpenableObject rampStatus;
    private int currentLoadedLength;
    private int maxLoadedLength;
    private Deque<Car> loadedCarStack = new ArrayDeque<>();

    public RampFlatbed(CarTransporter parent) {
        super();
        this.parent = parent;
        maxLoadedLength = getLength();
        rampStatus = OpenableObject.CLOSED;
    }

    //TODO: Check: Ramp is down, location, direction.
    public void loadFlatbed(Car car) {
        if (isObjectLoadable(car) && rampStatus == OpenableObject.OPEN) {
            loadedCarStack.push(car);
        }
    }

    public void openRamp() {
        if (parent.getCurrentSpeed() == 0) {
            rampStatus = OpenableObject.OPEN;
        } else {
            System.out.println("Truck is moving! Cannot open ramp!");
            throw new IllegalCallerException("Cannot open ramp while vehicle is moving!");
        }
    }

    public void closeRamp() {
        rampStatus = OpenableObject.CLOSED;
    }

    private boolean isObjectLoadable(Car car) {
        return !(isMaxLengthReached(car.getLength()) || isMaxWeightReached(car.getWeight()) || isMaxWidthReached(car.getWidth()));
    }

    private boolean isMaxWeightReached(int objectWeight) {
        return (objectWeight + getCurrentLoadedWeight() <= getMaxLoadableWeight());
    }

    private boolean isMaxLengthReached(int objectLength) {
        return (objectLength + currentLoadedLength + 10 >= maxLoadedLength);
    }

    private boolean isMaxWidthReached(int objectWidth) {
        return (objectWidth >= this.getWidth());
    }

    public OpenableObject getRampStatus() {
        return rampStatus;
    }
}