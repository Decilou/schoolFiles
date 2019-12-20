package Model;

import Event.ICarEventListener;

import java.util.Random;

import java.util.ArrayList;

public class CarModel {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<ICarEventListener> listeners = new ArrayList<>();

    private VehicleFactory factory;

    //Constructor
    public CarModel() {
        factory = new VehicleFactory();
        vehicles.add(factory.createVehicle(VehicleModelName.SAAB));
        vehicles.add(factory.createVehicle(VehicleModelName.SCANIA));
        vehicles.add(factory.createVehicle(VehicleModelName.VOLVO));
    }

    public void addRandomCar() {
        Random rand = new Random();
        if (vehicles.size() <= 10) {
            switch (rand.nextInt(3)) {
                case 0:
                    vehicles.add(factory.createVehicle(VehicleModelName.SAAB));
                case 1:
                    vehicles.add(factory.createVehicle(VehicleModelName.VOLVO));
                case 2:
                    vehicles.add(factory.createVehicle(VehicleModelName.SCANIA));
            }
        }
    }

    public void removeCar() {
        if (vehicles.size() > 0) {
            vehicles.remove(vehicles.size());
        }
    }

    public void createCarEvent(Vehicle v) {
        int x = (int) Math.round(v.getX());
        int y = (int) Math.round(v.getY());
        CarEvent currentCarEvent = new CarEvent(v.getCurrentSpeed(), x, y, v.getModelName());
        notifyListeners(currentCarEvent);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getWorldX() {
        return World.getWorldX();
    }

    public int getWorldY() {
        return World.getWorldY();
    }


    //-------------- LISTENER METHODS -----------------
    public void addListener(ICarEventListener l) {
        listeners.add(l);
    }

    public void removeListener(ICarEventListener l) {
        for (ICarEventListener listener : listeners) {
            if (listener == l) {
                listeners.remove(listener);
            }
        }
    }

    private void notifyListeners(CarEvent currentCareEvent) {
        for (ICarEventListener l : listeners) {
            l.update(currentCareEvent);
        }
    }
}
