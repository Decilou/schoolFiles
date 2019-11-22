import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class TestAngledFlatbed {


    private Scania testScania;

    @Before
    public void init(){
        testScania = new Scania(Color.blue);
    }

    @Test
    public void TestIfAngleIncreases (){

        int before = testScania.getAngledFlatbed().getAngle();

        testScania.getAngledFlatbed().tipFlatbed(1);

        int after = testScania.getAngledFlatbed().getAngle();

    }

}
