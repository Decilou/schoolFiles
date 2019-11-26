import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestCarTransporter {

    private CarTransporter testTransporter;

    @Before
    public void init(){
        testTransporter = new CarTransporter(Color.blue);

        testTransporter.startEngine();
    }

    // -------------------- MOVE --------------------


    @Test
    public void moveTestIfTruckIsFacingRIGHT () {

        assertTrue(testTransporter.getCurrentDirection() == Direction.RIGHT);

    }

    @Test
    public void moveTestIfMethodDoesNothingWhenEngineIsOf () {

        testTransporter.stopEngine();

        double before = testTransporter.getX();

        testTransporter.move();

        double after = testTransporter.getX();

        assertTrue(before == after);

    }

    @Test
    public void moveTestIfTruckMovesRIGHT () {

        double before = testTransporter.getX();

        testTransporter.startEngine();

        testTransporter.move();

        double after = testTransporter.getX();

        assertTrue(before < after);

    }

    @Test
    public void moveTestIfTruckMovesLEFT () {

        testTransporter = new CarTransporter(Color.red, Direction.LEFT);

        double before = testTransporter.getX();

        testTransporter.startEngine();

        testTransporter.move();

        double after = testTransporter.getX();

        assertTrue(before > after);

    }

    @Test
    public void moveTestIfTruckMovesUP () {

        testTransporter = new CarTransporter(Color.red, Direction.UP);

        double before = testTransporter.getY();

        testTransporter.startEngine();

        testTransporter.move();

        double after = testTransporter.getY();

        assertTrue(before > after);

    }

    @Test
    public void moveTestIfTruckMovesDOWN () {

        testTransporter = new CarTransporter(Color.red, Direction.DOWN);

        double before = testTransporter.getY();

        testTransporter.startEngine();

        testTransporter.move();

        double after = testTransporter.getY();

        assertTrue(before < after);

    }

    @Test
    public void moveTestIfTransporterCanMoveWithOpenRamp (){

        double before = testTransporter.getX();

        testTransporter.stopEngine();

        testTransporter.openRamp();

        testTransporter.startEngine();

        testTransporter.move();

        double after = testTransporter.getX();

        assertTrue(after == before);

    }

    @Test
    public void moveTestIfRampCanOpenWhileMoving (){

        OpenStatus before = testTransporter.getRampFlatbed().getRampStatus();

        testTransporter.openRamp();

        testTransporter.startEngine();

        testTransporter.move();

        OpenStatus after = testTransporter.getRampFlatbed().getRampStatus();

        assertTrue(before == after);

    }

    @Test
    public void moveTestIfFlatbedIsTooHeavy (){

        double before = testTransporter.getX();

        testTransporter.getRampFlatbed().setCurrentLoadedWeight(testTransporter.getMaxWeightToPull());

        testTransporter.startEngine();

        testTransporter.move();

        double after = testTransporter.getX();

        assertTrue(after == before);

    }

}
