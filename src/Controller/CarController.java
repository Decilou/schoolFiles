package Controller;

import Event.ICarEventListener;
import Event.ICarViewListener;
import Model.*;
import View.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController implements ICarViewListener {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    private CarModel model;

    //Constructor
    public CarController(CarView frame, CarModel model) {
        this.frame = frame;
        this.model = model;
        timer.start();
    }

    //methods:

    private void startCars() {
        for (Vehicle v : model.getVehicles()) {
            v.startEngine();
        }
    }

    // Calls the gas method for each car once
    private void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : model.getVehicles()) {
            v.gas(gas);
        }
    }

    private void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle v : model.getVehicles()) {
            v.brake(brake);
        }
    }

    private void stopCars() {
        for (Vehicle v : model.getVehicles()) {
            v.stopEngine();
        }
    }

    private void addCar(){
        model.addRandomCar();
    }

    private void removeCar(){
        model.removeCar();
    }

    //TODO: Remove the numbers. Replace with some sort of event.
    @Override
    public void update(int spinner, int counter) {

        switch (counter){
            case 1:
                gas(spinner);
                break;
            case 2:
                brake(spinner);
                break;
            case 3:
                startCars();
                break;
            case 4:
                stopCars();
                break;
            case 5:
                addCar();
                break;
            case 6:
                removeCar();
                break;
        }
    }

    public void addListener(ICarEventListener listener) {
        model.addListener(listener);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle v : model.getVehicles()) {
                v.move();

                int x = (int) Math.round(v.getX());
                int y = (int) Math.round(v.getY());
                v.collisionWithFrame(x, y);

                //Insert the current vehicle and create a CarEvent from it.
                model.createCarEvent(v);
            }
            model.notifyListeners();
            frame.repaint();
        }
    }
}
