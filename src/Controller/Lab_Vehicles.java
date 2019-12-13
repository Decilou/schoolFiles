package Controller;

import Model.Saab95;
import Model.Scania;
import Model.Volvo240;
import View.CarView;

import java.awt.*;

import static java.lang.System.out;

public class Lab_Vehicles {

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240(Color.cyan, 10, 10));
        cc.vehicles.add(new Saab95(Color.red, 10, 110));
        cc.vehicles.add(new Scania(Color.black, 10, 210));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }


}
