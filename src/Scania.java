import java.awt.*;

public class Scania extends Truck {

    private AngledFlatbed angledFlatbed;
    private int maxWeight;

    public Scania(double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection, int length, int width, int weight){
        super(enginePower, currentSpeed, color, modelName, currentDirection, length, width, weight);
        angledFlatbed = new AngledFlatbed(this);
        this.maxWeight = maxWeight;
    }


    @Override
    public void move(){
        if(angledFlatbed.getAngle() == 0){
            super.move();
        } else {
            System.out.println("Cannot move when flatbed is up!");
            throw new IllegalCallerException("Cannot move when flatbed is up.");
        }
    }

}
