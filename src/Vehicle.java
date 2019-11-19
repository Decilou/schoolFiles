import java.awt.*;

public abstract class Vehicle implements IMovable {

    private int nrDoors; // Number of doors of the vehicle
    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private String modelName; // The model name
    private Direction currentDirection; //Current direction
    private double x; // Position variable
    private double y; // Position variable
    private boolean isMoving = false;

    public Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection) {
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

    //-------------------- METHODS -----------------------------

    /**
     * Method that start the engine of the vehicle. Current speed set to 0.1.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Method that stop the engine of the vehicle. Current speed set to 0.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

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


    /**
     * Method that increase speed according to amount.
     * @param amount can be [0, 1]
     */
    public void gas(double amount) {
        if(0 <= amount && amount <= 1){
            incrementSpeed(amount);
        }
    }

    /**
     * Method that decrease speed according to amount.
     * @param amount can be [0, 1]
     */
    public void brake(double amount) {
        if(0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }
    }

    /**
     * Method that moves the vehicle in the direction it's facing.
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
     * Method that rotates the vehicle clockwise.
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
     * Method that rotates the vehicle 90 degrees counter-clockwise.
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

    public abstract double speedFactor();

    //------------------ GETTERS & SETTERS -----------------------------

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

    public boolean isMoving() {
        return isMoving;
    }
}
