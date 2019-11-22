import java.awt.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestCarWorkshop {

    private Volvo240 volvo240;
    private CarWorkshop<Volvo240> carWorkshop;

    @Before
    public void init(){
        volvo240 = new Volvo240(Color.red);
        carWorkshop = new CarWorkshop<>(6);
    }

    @Test
    public void numberOfCarsShouldBeMaxNumberOfCars(){

    }
}
