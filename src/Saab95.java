import java.awt.*;

public class Saab95 extends Cars {

    public boolean turboOn;


    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


    public void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }



}
