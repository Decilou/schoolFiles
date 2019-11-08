import java.awt.*;

public class Volvo240 extends Cars {

    public final static double trimFactor = 1.25;


    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        /*nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";

         */
    }

    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    public void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

}
