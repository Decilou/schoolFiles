import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestIncrementSpeed {

    private Saab95 testSaab;
    private Volvo240 testVolvo;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab");
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo");

    }

    @Test
    public void testIfMinimumIsChosenEngineOff() {

        assertTrue(testSaab.getCurrentSpeed() == 0);


    }

    @Test
    public void testIfMinimumIsChosenEngineOn() {

        testSaab.startEngine();

        assertTrue(testSaab.getCurrentSpeed() > 0 && testSaab.getCurrentSpeed() < 100);

    }

    @Test
    public void testThatTheSpeedIncreases () {

        testSaab.startEngine();

        double before = testSaab.getCurrentSpeed();

        testSaab.gas(1);

        double after = testSaab.getCurrentSpeed();

        assertTrue(before < after);

    }




}
