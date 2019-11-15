import java.awt.*;


/**
 * Class for a car. Has methods to start/stop engine, gas, brake.
 */
public abstract class Car implements IMovable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction currentDirection; //Current direction
    private double x; // Position variable
    private double y; // Position variable

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.currentDirection = currentDirection;
        x = 10;
        y = 10;
        stopEngine();
    }

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this(nrDoors,enginePower,currentSpeed,color,modelName,Direction.RIGHT);
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    private void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    /**
     * Method for increasing current speed.
     * @param amount amount to increase with.
     */
    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Method for decreasing current speed. If the speed is zero, do nothing.
     * @param amount amount to decrease with.
     */
    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }


    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "nrDoors=" + nrDoors +
                ", enginePower=" + enginePower +
                ", currentSpeed=" + currentSpeed +
                ", color=" + color +
                ", modelName='" + modelName + '\'' +
                '}';
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    private void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public double getX() {
        return x;
    }

    private void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    private void setY(double y) {
        this.y = y;
    }

    /**
     * Method that moves the car in the direction it's facing.
     */
    public void move(){
        if (currentSpeed != 0) {
            switch (getCurrentDirection()) {
                case RIGHT:
                    setX(getCurrentSpeed() + getX());
                    break;
                case LEFT:
                    setX(getCurrentSpeed()*-1 + getX());
                    break;
                case UP:
                    setY(getCurrentSpeed()*-1 + getY());
                    break;
                case DOWN:
                    setY(getCurrentSpeed() + getY());
                    break;
            }
        }
    }

    /**
     * Method that rotates the car 90 degrees clockwise.
     */
    public void turnRight(){
        switch (getCurrentDirection()) {
            case UP:
                setCurrentDirection(Direction.RIGHT);
                break;
            case RIGHT:
                setCurrentDirection(Direction.DOWN);
                break;
            case DOWN:
                setCurrentDirection(Direction.LEFT);
                break;
            case LEFT:
                setCurrentDirection(Direction.UP);
                break;

        }
    }

    /**
     * Method that rotates the car 90 degrees counter-clockwise.
     */
    public void turnLeft() {
        switch (getCurrentDirection()) {
            case UP:
                setCurrentDirection(Direction.LEFT);
                break;
            case LEFT:
                setCurrentDirection(Direction.DOWN);
                break;
            case DOWN:
                setCurrentDirection(Direction.RIGHT);
                break;
            case RIGHT:
                setCurrentDirection(Direction.UP);
                break;
        }
    }
}
