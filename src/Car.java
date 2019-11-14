import java.awt.*;

public abstract class Car implements IMovable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction currentDirection;
    private int x;
    private int y;

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        currentDirection = Direction.RIGHT;
        x = 10;
        y = 10;
        stopEngine();
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
     *
     * @param amount meaning the amount the sped will increase with.
     */

    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     *
     * @param amount
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
        this.x = (int) x;
    }

    public double getY() {
        return y;
    }

    private void setY(double y) {
        this.y = (int) y;
    }

    /**
     *
     */

    public void move(){
        //move backwards or forwards in the direction the car is facing.

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
     *
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
     * This method tells the car what to do when it turns left.
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
