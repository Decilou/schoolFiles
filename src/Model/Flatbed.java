package Model;

/**
 * Class for a flatbed.
 */

public abstract class Flatbed implements ITansporter {
    private final int length; // The length of the flatbed
    private final int height;
    private final int width; // The width of the flatbed
    private final int weight; // the weight of the flatbed itself when unloaded.
    private final int maxLoadableWeight; // The max weight the flatbed can take.
    private double x;
    private double y;
    private Direction currentDirection; //Current direction
    private boolean isLoaded;
    private int currentLoadedWeight; // The current weight of the load on the flatbed.

    public Flatbed(int length, int width, int height, int weight, int maxLoadableWeight, double x, double y) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.height = height;
        this.maxLoadableWeight = maxLoadableWeight;
        this.currentDirection = Direction.RIGHT;
        isLoaded = false;
    }

    public Flatbed() {
        x = 10;
        y = 10;
        length = 1463;
        width = 244;
        height = 300;
        weight = 453;
        maxLoadableWeight = 21772;
        this.currentDirection = Direction.RIGHT;

    }

    public boolean isValidToLoad(ITransportable t){

        return (isLengthValid(t) &&
                isHeightValid(t) &&
                isLocationValid(t) &&
                isWidthValid(t) &&
                isWeightValid(t));
    }

    private boolean isLengthValid(ITransportable t) {

        return true;
    }

    private boolean isHeightValid(ITransportable t) {
        return true;
    }

    private boolean isWidthValid(ITransportable t){
        return true;
    }

    private boolean isWeightValid(ITransportable t) {
        return true;
    }

    private boolean isLocationValid(ITransportable t){
        return true;
    }

    //-------------------- GETTERS & SETTERS --------------------

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxLoadableWeight() {
        return maxLoadableWeight;
    }

    public int getCurrentLoadedWeight() {
        return currentLoadedWeight;
    }

    public void setCurrentLoadedWeight(int currentLoadedWeight) {
        this.currentLoadedWeight = currentLoadedWeight;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}