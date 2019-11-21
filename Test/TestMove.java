import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;


public class TestMove {

    private Saab95 testSaab;
    private Volvo240 testVolvo;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab",0,0,0);
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo",0,0,0);

    }

    @Test
    public void testIfCarIsFacingRIGHT () {

        assertTrue(testVolvo.getCurrentDirection() == Direction.RIGHT);

    }

    @Test
    public void testIfMethodDoesNothingWhenEngineIsOf () {

        double before = testVolvo.getX();

        testVolvo.move();

        double after = testVolvo.getX();

        assertTrue(before == after);

    }

    @Test
    public void testIfCarMovesRIGHT () {

        double before = testVolvo.getX();

        testVolvo.startEngine();

        testVolvo.move();

        double after = testVolvo.getX();

        assertTrue(before < after);

    }

    @Test
    public void testIfCarMovesLEFT () {

        testVolvo = new Volvo240(4,100,0, Color.red, "volvo", Direction.LEFT,0,0,0);

        double before = testVolvo.getX();

        testVolvo.startEngine();

        testVolvo.move();

        double after = testVolvo.getX();

        assertTrue(before > after);

    }

    @Test
    public void testIfCarMovesUP () {

        testVolvo.turnLeft();

        double before = testVolvo.getY();

        testVolvo.startEngine();

        testVolvo.move();

        double after = testVolvo.getY();

        assertTrue(before > after);

    }

    @Test
    public void testIfCarMovesDOWN () {

        testVolvo.turnRight();

        double before = testVolvo.getY();

        testVolvo.startEngine();

        testVolvo.move();

        double after = testVolvo.getY();

        assertTrue(before < after);

    }

}
