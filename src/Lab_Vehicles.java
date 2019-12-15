import Controller.CarController;
import Model.VehicleFactory;
import Model.Saab95;
import Model.Volvo240;
import View.CarView;

import java.awt.*;

public class Lab_Vehicles {

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }


}
