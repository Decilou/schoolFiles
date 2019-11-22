/**
 * Class for
 */

public abstract class Flatbed {
    private final int length; // The length of the flatbed
    private final int width; // The width of the flatbed
    private final int weight; // the weight of the flatbed itself when unloaded.
    private final int maxLoadableWeight; // The max weight the flatbed can take.
    private int currentLoadedWeight; // The current weight of the load on the flatbed.

    public Flatbed(int length, int width, int weight, int maxLoadableWeight) {
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.maxLoadableWeight = maxLoadableWeight;
    }

    public Flatbed() {
        length = 1463;
        width = 244;
        weight = 453;
        maxLoadableWeight = 21772;
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
}