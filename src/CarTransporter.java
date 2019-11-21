import java.awt.*;

public class CarTransporter extends Truck {

    private RampFlatbed rampFlatbed;
    int maxWeight;

    public CarTransporter(double enginePower, Color color, String modelName, Direction currentDirection, int length, int width, int weight){
        super(enginePower, color, modelName, currentDirection, length, width, weight);
        rampFlatbed = new RampFlatbed(this);
    }


    @Override
    public void move(){
        if(rampFlatbed.getRampStatus() == OpenStatus.CLOSED){
            super.move();
        } else {
            System.out.println("Cannot move when the ramp is down!");
            throw new IllegalCallerException("Cannot move when the ramp is down.");
        }
    }

    public void loadUpCar () {


    }




}
