package Model;

import java.awt.*;
import java.util.Objects;

import static java.lang.System.out;

public abstract class Vehicle implements IMovable, ITansporter, ITransportable {

    private final int nrDoors; // Number of doors of the vehicle
    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private final String modelName; // The model name
    private Direction currentDirection; //Current direction
    private double x; // Position variable
    private double y; // Position variable
    private final int length; // Length of the vehicle
    private final int width; // Width of the vehicle
    private final int height;
    private int weight; // Weight of the vehicle
    private boolean isLoaded;


    Vehicle(int nrDoors, double enginePower, Color color, String modelName, Direction currentDirection, int length, int width, int height, int weight, double x, double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.currentDirection = currentDirection;
        this.x = x;
        this.y = y;
        stopEngine();
        this.length = length;
        this.height = height;
        this.width = width;
        this.weight = weight;
        isLoaded  = false;

    }

    Vehicle(int nrDoors, double enginePower, Color color, String modelName, int length, int width, int height, int weight, double x, double y) {
        this(nrDoors, enginePower, color, modelName, Direction.RIGHT, length, width, height, weight,x,y);
    }

    //-------------------- METHODS --------------------

    //TODO: Figure out how to validate the transporter.
    public void loadOnTransporter (Vehicle transporter) {
        if (!isLoaded && !isMoving() && transporter.isValidToLoad(this)){
            stopEngine();
            isLoaded = true;
        }
    }

    //TODO: Move the collision detection into a seperate class.
    public void collisionWithFrame(int x, int y) {
        if (x >= World.getWorldX() - 100 || x <= 0 || y <= 0 || y >= World.getWorldY()) {
            turnRight();
            turnRight();
        }
    }

    public void unload() {
        if (isLoaded){
            placeUnloadedVehicleInWorld();
            isLoaded = false;
        }
    }

    public void updateTransportedVehicle (Vehicle transporter) {

        if (isLoaded){
            this.setX(transporter.getX());
            this.setY(transporter.getY());
            this.setCurrentDirection(transporter.getCurrentDirection());
        }
    }

    public boolean isValidToLoad(ITransportable t){

        return (isLengthValid(t) &&
                isHeightValid(t) &&
                isLocationValid(t) &&
                isWidthValid(t) &&
                isWeightValid(t));
    }

    // TODO: All these values are set to true. Figure out how validation should work.
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

    private void placeUnloadedVehicleInWorld() {

        double y = getY();
        double x = getX();

        if (isLoaded) {
            switch (this.getCurrentDirection()) {
                case UP:
                    setY(y + 10);
                case RIGHT:
                    setX(x - 10);
                case DOWN:
                    setY(y - 10);
                case LEFT:
                    setX(x + 10);
            }
        }
    }

    public boolean isMoving() {
        return (currentSpeed != 0);
    }

    /**
     * Method that start the engine of the vehicle. Current speed set to 0.1.
     */
    public void startEngine() {
        if (!isLoaded) {
            currentSpeed = 0.1;
        } else {
            out.println("Can't start engine when being stored");
        }
    }

    /**
     * Method that stop the engine of the vehicle. Current speed set to 0.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Method for increasing current speed.
     *
     * @param amount amount to increase with.
     */
    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Method for decreasing current speed. If the speed is zero, do nothing.
     *
     * @param amount amount to decrease with.
     */
    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }


    /**
     * Method that increase speed according to amount.
     *
     * @param amount can be [0, 1]
     */
    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    /**
     * Method that decrease speed according to amount.
     *
     * @param amount can be [0, 1]
     */
    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    /**
     * Method that moves the vehicle in the direction it's facing.
     */
    public void move() {
        if (currentSpeed != 0) {
            switch (getCurrentDirection()) {
                case RIGHT:
                    setX(getCurrentSpeed() + getX());
                    break;
                case LEFT:
                    setX(getCurrentSpeed() * -1 + getX());
                    break;
                case UP:
                    setY(getCurrentSpeed() * -1 + getY());
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
    public void turnRight() {
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

    //-------------------- GETTERS & SETTERS --------------------

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

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public String toString() {
        return "Model.Vehicle{" +
                "nrDoors=" + nrDoors +
                ", enginePower=" + enginePower +
                ", currentSpeed=" + currentSpeed +
                ", color=" + color +
                ", modelName='" + modelName + '\'' +
                ", currentDirection=" + currentDirection +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public String getModelName() {
        return modelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return nrDoors == vehicle.nrDoors &&
                Double.compare(vehicle.enginePower, enginePower) == 0 &&
                Double.compare(vehicle.currentSpeed, currentSpeed) == 0 &&
                Double.compare(vehicle.x, x) == 0 &&
                Double.compare(vehicle.y, y) == 0 &&
                length == vehicle.length &&
                width == vehicle.width &&
                height == vehicle.height &&
                weight == vehicle.weight &&
                isLoaded == vehicle.isLoaded &&
                Objects.equals(color, vehicle.color) &&
                Objects.equals(modelName, vehicle.modelName) &&
                currentDirection == vehicle.currentDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrDoors, enginePower, currentSpeed, color, modelName, currentDirection, x, y, length, width, height, weight, isLoaded);
    }
}
