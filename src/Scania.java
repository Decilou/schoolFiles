import java.awt.*;

public class Scania extends Truck {

    private AngledFlatbed angledFlatbed;
    private int maxWeightToPull;

    public Scania(Color color, Direction currentDirection){
        super(500, color, "Scania", currentDirection, 593, 255, 18000);
        angledFlatbed = new AngledFlatbed(this);
        this.maxWeightToPull = 40000;
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
