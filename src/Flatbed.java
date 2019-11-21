public abstract class Flatbed {
    private int length;
    private int width;
    private int weight;
    private int maxLoadingWeight;

    public Flatbed(int length, int width, int weight, int maxLoadingWeight) {
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.maxLoadingWeight = maxLoadingWeight;
    }

    public Flatbed() {
        length = 1463;
        width = 244;
        weight = 453;
        maxLoadingWeight = 21772;
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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxLoadingWeight() {
        return maxLoadingWeight;
    }

    public void setMaxLoadingWeight(int maxLoadingWeight) {
        this.maxLoadingWeight = maxLoadingWeight;
    }
}