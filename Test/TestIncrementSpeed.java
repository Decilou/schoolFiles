import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestIncrementSpeed {

    private Saab95 testSaab;
    private Volvo240 testVolvo;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab",0,0,0);
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo",0,0,0);

        testSaab.startEngine();


    }

    @Test
    public void testIfMinimumIsChosenEngineOff() {

        testSaab.stopEngine();

        assertTrue(testSaab.getCurrentSpeed() == 0);


    }

    @Test
    public void testIfMinimumIsChosenEngineOn() {

        assertTrue(testSaab.getCurrentSpeed() > 0 && testSaab.getCurrentSpeed() < 100);

    }

    @Test
    public void testThatTheSpeedIncreases() {

        double before = testSaab.getCurrentSpeed();

        testSaab.gas(1);

        double after = testSaab.getCurrentSpeed();

        assertTrue(before < after);

    }


}
