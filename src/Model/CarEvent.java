package Model;

public class CarEvent {

    private double currentSpeed;
    private int x;
    private int y;
    private String modelName;

    //Constructor
    CarEvent(double currentSpeed, int x, int y, String modelName) {
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
        this.modelName = modelName;
    }

    //Getters
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getModelName() {
        return modelName;
    }
}
