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
}