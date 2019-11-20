import java.awt.*;

public class Scania extends Truck {

    private AngledFlatbed angledFlatbed;

    public Scania(double enginePower, double currentSpeed, Color color, String modelName, Direction currentDirection){
        super(enginePower, currentSpeed, color, modelName, currentDirection);
        angledFlatbed = new AngledFlatbed(this);
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
