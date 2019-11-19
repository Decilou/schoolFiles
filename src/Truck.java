import java.awt.*;

public abstract class Truck extends Vehicle {

    private Flatbed flatbed;

    public Truck(double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection) {
        super(2, enginePower, currentSpeed, color, modelName, currentDirection);
        flatbed = new Flatbed(0, this);
    }

    @Override
    public void move(){
        if(flatbed.getAngle() == 0){
            super.move();
        } else {
            System.out.println("Cannot move when flatbed is up!");
            throw new IllegalCallerException("Cannot move when flatbed is up.");
        }
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
