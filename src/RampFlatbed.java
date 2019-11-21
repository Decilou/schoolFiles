import java.util.ArrayDeque;
import java.util.Deque;

/*TODO: Method for unloading car.
TODO: Loaded car's position is according to CarTransporter if loaded.
TODO: Add final on all instance variable that should be immutable.
 */

/**
 * Class for a flatbed with an attached ramp at the end.
 * Has methods to load and unload cars onto flatbed if ramp is down.
 */

public class RampFlatbed extends Flatbed {
    private CarTransporter parent;
    private OpenStatus rampStatus;
    private int currentLoadedLength;
    private final int maxLoadedLength;
    private Deque<Car> loadedCarsStack = new ArrayDeque<>();

    public RampFlatbed(CarTransporter parent) {
        super();
        this.parent = parent;
        maxLoadedLength = getLength();
        rampStatus = OpenStatus.CLOSED;
    }

    /**
     * Load object onto flatbed if all conditions are valid.
     *
     * @param car object to be loaded onto flatbed
     */
    public void loadFlatbed(Car car) {
        if (isObjectLoadable(car) && rampStatus == OpenStatus.OPEN && isLocationValid(car) && isDirectionValid(car)) {
            loadedCarsStack.push(car);
            currentLoadedLength += car.getLength() + 10;
        }
    }

    /**
     * Unload object from flatbed if ramp is open and flatbed is not empty.
     *
     * @return car that was unloaded
     */
    public Car unloadFlatbed() {
        if (rampStatus == OpenStatus.OPEN && !loadedCarsStack.isEmpty()) {
            return loadedCarsStack.poll();
        } else {
            System.out.println("There are no cars left!");
            throw new IllegalCallerException("There are no cars left!");
        }
    }

    /**
     * Check if object is close enough of the flatbed to be loaded.
     *
     * @param car object to be loaded
     * @return true if location is valid for loading car
     */
    private boolean isLocationValid(Car car) {
        double x = parent.getX();
        double y = parent.getY();

        return (x - 10 < car.getX() && car.getX() < x + 10 && y - 10 < car.getY() && car.getY() < y + 10);
    }

    /**
     * Check if direction of truck matches direction of car to be loaded.
     *
     * @param car to be loaded
     * @return true if directions match
     */
    private boolean isDirectionValid(Car car) {
        return (parent.getCurrentDirection() == car.getCurrentDirection());
    }

    /**
     * Set ramp to open if flatbed is not moving. Else, throw exception.
     */
    public void openRamp() {
        if (parent.getCurrentSpeed() == 0) {
            rampStatus = OpenStatus.OPEN;
        } else {
            System.out.println("Truck is moving! Cannot open ramp!");
            throw new IllegalCallerException("Cannot open ramp while vehicle is moving!");
        }
    }

    /**
     * Set ramp to closed.
     */
    public void closeRamp() {
        rampStatus = OpenStatus.CLOSED;
    }

    /**
     * Check if object is loadable onto flatbed.
     *
     * @param car to be loaded
     * @return true if object is loadable
     */
    private boolean isObjectLoadable(Car car) {
        return !(isMaxLengthReached(car.getLength()) || isMaxWeightReached(car.getWeight()) || isMaxWidthReached(car.getWidth()));
    }

    /**
     * Check if max loadable weight will be reached when object has been loaded.
     *
     * @param objectWeight weight of the object to be loaded
     * @return true if max loadable weight will not be exceeded after loading object
     */
    private boolean isMaxWeightReached(int objectWeight) {
        return (objectWeight + getCurrentLoadedWeight() <= getMaxLoadableWeight());
    }

    /**
     * Check if max loadable length will be reached when object has been loaded.
     *
     * @param objectLength length of the object to be loaded
     * @return true if max loadable length will not be exceeded after loading object
     */
    private boolean isMaxLengthReached(int objectLength) {
        return (objectLength + currentLoadedLength + 10 >= maxLoadedLength);
    }

    /**
     * Check if max loadable width will be reached when object has been loaded.
     *
     * @param objectWidth width of the object to be loaded
     * @return true if max loadable width will not be exceeded after loading object
     */
    private boolean isMaxWidthReached(int objectWidth) {
        return (objectWidth >= this.getWidth());
    }

    public OpenStatus getRampStatus() {
        return rampStatus;
    }
}