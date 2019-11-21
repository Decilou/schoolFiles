import java.awt.*;

public class CarTransporter extends Truck {

    private Ramp ramp;
    int maxWeight;

    public CarTransporter(double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection, int length, int width, int weight){
        super(enginePower, currentSpeed, color, modelName, currentDirection, length, width, weight);
        ramp = new Ramp(this);
    }


    @Override
    public void move(){
        if(ramp.getAngle() == 90){
            super.move();
        } else {
            System.out.println("Cannot move when the ramp is down!");
            throw new IllegalCallerException("Cannot move when the ramp is down.");
        }
    }

    public void loadUpCar () {


    }




}
