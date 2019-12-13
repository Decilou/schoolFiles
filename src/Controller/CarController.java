package Controller;

import Model.Saab95;
import Model.Scania;
import Model.Vehicle;
import Model.Volvo240;
import View.CarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    public CarView frame;
    // A list of cars, modify if needed
    public ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public void startCars() {
        for (Vehicle v : vehicles) {
            v.startEngine();
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : vehicles) {
            v.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle v : vehicles
        ) {
            v.brake(brake);
        }
    }

    public void stopCars() {
        for (Vehicle v : vehicles) {
            v.stopEngine();
        }
    }


    // TODO Fundera över getPosition behövs .
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle v : vehicles) {
                v.move();
                int x = (int) Math.round(v.getX());
                int y = (int) Math.round(v.getY());

                v.collisionWithFrame(x, y);

                frame.drawPanel.moveIt(x, y, v);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

}
