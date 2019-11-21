public abstract class Flatbed {
    private final int length;
    private final int width;
    private final int weight;
    private final int maxLoadableWeight;
    private int currentLoadedWeight;

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