import java.awt.*;

public class CarTransporter extends Truck {

    private Ramp ramp;

    public CarTransporter(double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection){
        super(enginePower, currentSpeed, color, modelName, currentDirection);
        ramp = new Ramp(this);
    }


    @Override
    public void move(){
        if(ramp.getAngle() == 90){
            super.move();
        } else {
            System.out.println("Cannot move when flatbed is up!");
            throw new IllegalCallerException("Cannot move when flatbed is up.");
        }
    }



}
