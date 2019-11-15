import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestDecrementSpeed {

    private Saab95 testSaab;
    private Volvo240 testVolvo;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab");
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo");

    }

    @Test
    public void testIfMaximumIsChosenEngineOff() {

        assertTrue(testSaab.getCurrentSpeed() == 0);

    }

    @Test
    public void testIfMaximumIsChosenEngineOn() {

        testSaab.startEngine();

        assertTrue(testSaab.getCurrentSpeed() > 0 && testSaab.getCurrentSpeed() < 100);

    }

    @Test
    public void testThatTheSpeedDecreases () {

        testSaab.startEngine();

        testSaab.gas(1);

        double before = testSaab.getCurrentSpeed();

        testSaab.brake(1);

        double after = testSaab.getCurrentSpeed();

        assertTrue(before > after);

    }




}
