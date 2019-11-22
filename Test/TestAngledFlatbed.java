import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestAngledFlatbed {


    private Scania testScania;

    @Before
    public void init(){
        testScania = new Scania(Color.blue);
    }

    @Test
    public void TestIfAngleIncreases (){

        int before = testScania.getAngledFlatbed().getAngle();

        testScania.getAngledFlatbed().tipFlatbed();

        int after = testScania.getAngledFlatbed().getAngle();

        assertTrue(before < after);

    }

    @Test
    public void TestIfAngleDecreases (){

        testScania.getAngledFlatbed().tipFlatbed();

        int before = testScania.getAngledFlatbed().getAngle();

        testScania.getAngledFlatbed().lowerFlatbed();

        int after = testScania.getAngledFlatbed().getAngle();

        assertTrue(before > after);

    }

    @Test
    public void TestIfAngleCanChangeWhenTruckIsMoving() {
        int before = testScania.getAngledFlatbed().getAngle();

        testScania.gas(1);

        int after = testScania.getAngledFlatbed().getAngle();

        assertTrue(before == after);
    }

    @Test
    public void TestIfAngleCanChangeOutsideOfParameters() {
        int before = testScania.getAngledFlatbed().getAngle();

        testScania.getAngledFlatbed().lowerFlatbed();

        int after = testScania.getAngledFlatbed().getAngle();

        assertTrue(before == after);
    }

}
