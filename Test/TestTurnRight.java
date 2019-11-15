import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestTurnRight {

    private Saab95 testSaab;
    private Volvo240 testVolvo;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab");
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo");

    }

    @Test
    public void testDirectionChange () {

        testSaab.turnRight();

        assertTrue(testSaab.getCurrentDirection() == Direction.DOWN);

    }

    @Test
    public void testOfALoop() {

        testSaab.turnRight();
        testSaab.turnRight();
        testSaab.turnRight();
        testSaab.turnRight();


        assertTrue(testSaab.getCurrentDirection() == Direction.RIGHT);

    }


}
