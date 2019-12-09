import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCarWorkshop {

    private Volvo240 volvo240;
    private Saab95 saab95;

    private Volvo240 volvo240nr2;
    private CarWorkshop<Volvo240> carWorkshop;

    @Before
    public void init() {
        volvo240 = new Volvo240(Color.red,10,10);
        saab95 = new Saab95(Color.black,10,10);
        carWorkshop = new CarWorkshop<>(2);
    }

    @Test
    public void currentNumberOfCars_shouldBeZero() {
        assertTrue(carWorkshop.currentNumberOfCars() == 0);
    }

    @Test
    public void isFull_workshopShouldNotBeFull() {
        assertTrue(!carWorkshop.isFull());
    }

    @Test
    public void isFull_workshopShouldBeFull() {
        volvo240nr2 = new Volvo240(Color.black,10,10);

        carWorkshop.loadCarIntoWorkshop(volvo240);
        carWorkshop.loadCarIntoWorkshop(volvo240nr2);
        assertTrue(carWorkshop.isFull());
    }

    @Test
    public void loadCarIntoWorkshop_carShouldBeInList(){
        carWorkshop.loadCarIntoWorkshop(volvo240);
        assertTrue(!carWorkshop.isEmpty());
    }

    @Test
    public void unloadCarFromWorkshop_sameCarAsLoadedShouldBeUnloaded(){
        carWorkshop.loadCarIntoWorkshop(volvo240);

        assertTrue(carWorkshop.unloadCarFromWorkshop(volvo240) == volvo240);
    }

    @Test
    public void unloadCarFromWorkshop_carIsNotInWorkshop() {

        assertTrue(!(carWorkshop.unloadCarFromWorkshop(volvo240) == volvo240));
    }
}
