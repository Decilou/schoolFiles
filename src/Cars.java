import java.awt.*;

public abstract class Cars implements IMovable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    public Cars(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
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

    protected void setCurrentSpeed(double currentSpeed) {
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

    /**
     * Increases speed according to different equations depending on the subclass.
     * (för användaren av koden som kanske inte vet
     * det tekniska. Förklara helt enkelt. Inte vad den implementerar osv
     * @param amount skriv några ord här.
     */

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);


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


    public void move(){
        //move backwards or forwards in the direction the car is facing.

        if (currentSpeed != 0) {
            switch (this.getDirection) {
                case RIGHT;
                    Position = getCurrentSpeed() + currentLocation;
                case LEFT;
                    Position = -1*getCurrentSpeed() + currentLocation;


            }
            Position = getCurrentSpeed() + currentLocation;
        }

    }


    public void turnLeft(){

    }


    public void turnRight(){

    }
}
