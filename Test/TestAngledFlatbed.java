import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestAngledFlatbed {


    private AngledFlatbed testFlatbed;

    @Before
    public void init(){
        testFlatbed = new AngledFlatbed();
    }

    @Test
    public void TestIfAngleIncreases (){

        int before = testFlatbed.getAngle();

        testFlatbed.tipFlatbed();

        int after = testFlatbed.getAngle();

        assertTrue(before < after);

    }

    @Test
    public void TestIfAngleDecreases (){

        testFlatbed.tipFlatbed();

        int before = testFlatbed.getAngle();

        testFlatbed.lowerFlatbed();

        int after = testFlatbed.getAngle();

        assertTrue(before > after);

    }

    @Test
    public void TestIfAngleCanChangeOutsideOfParameters() {
        int before = testFlatbed.getAngle();

        testFlatbed.lowerFlatbed();

        int after = testFlatbed.getAngle();

        assertTrue(before == after);
    }

}
