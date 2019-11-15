import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestSpeedFactor {

    private Saab95 testSaab;
    private Volvo240 testVolvo;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab");
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo");
    }

    @Test
    public void testIfSaabTurboChangesSpeedFactor () {
        testSaab.startEngine();
        

    }


}
