import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;


public class TestGettersAndSetters {

    private Saab95 testSaab;
    private Volvo240 testVolvo;
    private Volvo240 testVolvo2;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab");
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo");
        testVolvo2 = new Volvo240(6,200,0, Color.black, "Mark");
    }

    @Test
    public void testOfGetColor (){

        assertTrue(testVolvo.getColor() != testVolvo2.getColor() );

    }

    @Test
    public void testOfGetNumberOfDoors(){

        assertTrue(testVolvo.getNrDoors() != testVolvo2.getNrDoors() );

    }

    @Test
    public void testOfToString(){

        assertTrue(testVolvo.toString().contains("volvo"));

    }


}
