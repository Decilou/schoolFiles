import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import static java.lang.System.out;



public class TestSpeedFactor {

    private Saab95 testSaab;
    private Volvo240 testVolvo;
    private Volvo240 testVolvo2;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab");
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo");
        testVolvo2 = new Volvo240(6,200,0, Color.black, "Mark");

        testSaab.startEngine();
    }

    @Test
    public void testIfSaabTurboOnChangesSpeedFactor () {

        double before = testSaab.speedFactor();

        testSaab.setTurboOn();

        double after = testSaab.speedFactor();

        assertTrue(before < after);

    }

    @Test
    public void testIfSaabTurboOffChangesSpeedFactor () {

        testSaab.setTurboOn();

        double before = testSaab.speedFactor();

        testSaab.setTurboOff();


        double after = testSaab.speedFactor();

        assertTrue(before > after);

    }

    @Test
    public void testIfEnginePowerChangesSpeedFactor () {

        assertTrue(testVolvo2.speedFactor() > testVolvo.speedFactor());

    }
}
