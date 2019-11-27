import java.util.ArrayDeque;
import java.util.Deque;


//TODO: Add final on all instance variable that should be immutable.
//TODO: Remove all instances of parent. Avoiding double dependency between rampFlatbed and CarTransporter.


/**
 * Class for a flatbed with an attached ramp at the end.
 * Has methods to load and unload cars onto flatbed if ramp is down.
 */

public class RampFlatbed extends Flatbed {
    private OpenStatus rampStatus; // The status of the ramp. It can be either open or closed.
    private int currentLoadedLength; // The sum of the length of all loaded objects.
    private final int maxLoadedLength; //the maximum length that the flatbed can take.
    private Deque<Car> loadedCarsStack = new ArrayDeque<>(); //A stack of the cars that are loaded on the flatbed.

    public RampFlatbed() {
        super();
        maxLoadedLength = getLength();
        rampStatus = OpenStatus.CLOSED;
    }


    //-------------------- METHODS --------------------

    /**
     * Load object onto flatbed if all conditions are valid.
     *
     * @param car object to be loaded onto flatbed
     */
    public void loadFlatbed(Car car) {
        if (isObjectLoadable(car) && rampStatus == OpenStatus.OPEN && isLocationValid(car) && isDirectionValid(car) && !car.isLoaded()) {
            loadedCarsStack.push(car);
            currentLoadedLength += car.getLength() + 10;
            car.loadOnTransporter();
        }
    }



    /**
     * Unload object from flatbed if ramp is open and flatbed is not empty.
     *
     * @return car that was unloaded
     */
    public Car unloadObjectFromFlatbed() {
        if (rampStatus == OpenStatus.OPEN && !loadedCarsStack.isEmpty() ) {
            Car unloadedCar = loadedCarsStack.pop();
            unloadedCar.placeUnloadedVehicle    InWorld();
            return unloadedCar;
        } else {
            System.out.println("There are no cars left!");
            return null;
        }
    }


    /**
     * Check if object is close enough of the flatbed to be loaded.
     *
     * @param car object to be loaded
     * @return true if location is valid for loading car
     */
    private boolean isLocationValid(Car car) {
        double x = this.getX();
        double y = this.getY();

        return (x - 10 < car.getX() && car.getX() < x + 10 && y - 10 < car.getY() && car.getY() < y + 10);
    }

    /**
     * Check if direction of truck matches direction of car to be loaded.
     *
     * @param car to be loaded
     * @return true if directions match
     */
    private boolean isDirectionValid(Car car) {
        return (this.getCurrentDirection() == car.getCurrentDirection());
    }

    /**
     * Set ramp to open if flatbed is not moving. Else, throw exception.
     */
    public void openRamp() {
        rampStatus = OpenStatus.OPEN;
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

    //-------------------- GETTERS & SETTERS --------------------

    public OpenStatus getRampStatus() {
        return rampStatus;
    }

    public int getCurrentLoadedLength() {
        return currentLoadedLength;
    }

    public int getMaxLoadedLength() {
        return maxLoadedLength;
    }

    public Deque<Car> getLoadedCarsStack() {
        return loadedCarsStack;
    }
}