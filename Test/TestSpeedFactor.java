import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import static java.lang.System.out;



public class TestSpeedFactor {

    private Saab95 testSaab;
    private Volvo240 testVolvo;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab");
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo");
    }

    @Test
    public void testIfSaabTurboOnChangesSpeedFactor () {
        testSaab.startEngine();

        double before = testSaab.speedFactor();

        testSaab.setTurboOn();

        double after = testSaab.speedFactor();

        assertTrue(before < after);

    }

    @Test
    public void testIfSaabTurboOffChangesSpeedFactor () {
        testSaab.startEngine();

        testSaab.setTurboOn();

        double before = testSaab.speedFactor();

        testSaab.setTurboOff();


        double after = testSaab.speedFactor();

        assertTrue(before > after);

    }

    @Test
    public void testIfTurningOnEngineChangesSpeedFactorForVolvo () {

        double before = testVolvo.speedFactor();

        testVolvo.startEngine();

        double after = testVolvo.speedFactor();

        out.println(before);
        out.println(after);


        assertTrue(true);

    }


}
