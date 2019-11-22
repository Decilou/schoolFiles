import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestScania {

    private Scania testScania;

    @Before
    public void init(){
        testScania = new Scania(Color.blue);
    }


    // -------------------- MOVE --------------------


    @Test
    public void moveTestIfTruckIsFacingRIGHT () {

        assertTrue(testScania.getCurrentDirection() == Direction.RIGHT);

    }

    @Test
    public void moveTestIfMethodDoesNothingWhenEngineIsOf () {

        testScania.stopEngine();

        double before = testScania.getX();

        testScania.move();

        double after = testScania.getX();

        assertTrue(before == after);

    }

    @Test
    public void moveTestIfTruckMovesRIGHT () {

        double before = testScania.getX();

        testScania.startEngine();

        testScania.move();

        double after = testScania.getX();

        assertTrue(before < after);

    }

    @Test
    public void moveTestIfTruckMovesLEFT () {

        testScania = new Scania(Color.red, Direction.LEFT);

        double before = testScania.getX();

        testScania.startEngine();

        testScania.move();

        double after = testScania.getX();

        assertTrue(before > after);

    }

    @Test
    public void moveTestIfTruckMovesUP () {

        testScania = new Scania(Color.red, Direction.UP);

        double before = testScania.getY();

        testScania.startEngine();

        testScania.move();

        double after = testScania.getY();

        assertTrue(before > after);

    }

    @Test
    public void moveTestIfTruckMovesDOWN () {

        testScania = new Scania(Color.red, Direction.DOWN);

        double before = testScania.getY();

        testScania.startEngine();

        testScania.move();

        double after = testScania.getY();

        assertTrue(before < after);

    }

    @Test
    public void moveTestIfFlatbedAngleStopsTruckFromMoving (){

        double before = testScania.getX();

        testScania.getAngledFlatbed().tipFlatbed(1);

        testScania.move();

        double after = testScania.getX();

        assertTrue(after == before);

    }

    @Test
    public void moveTestIfFlatbedIsTooHeavy (){

        double before = testScania.getX();

        testScania.getAngledFlatbed().setCurrentLoadedWeight(testScania.getMaxWeightToPull());

        double after = testScania.getX();

        assertTrue(after == before);

    }






}
