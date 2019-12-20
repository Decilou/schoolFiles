package Model;

import Event.ICarEventListener;

import java.util.Random;

import java.util.ArrayList;

public class CarModel {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<ICarEventListener> listeners = new ArrayList<>();
    private ArrayList<CarEvent> drawingObjects = new ArrayList<>();

    private VehicleFactory factory;

    //Constructor
    public CarModel() {
        factory = new VehicleFactory(vehicles);
        vehicles.add(factory.createVehicle(VehicleModelName.SAAB));
    }

    public void addRandomCar() {
        Random rand = new Random();
        if (vehicles.size() <= 10) {
            switch (rand.nextInt(3)) {
                case 0:
                    vehicles.add(factory.createVehicle(VehicleModelName.SAAB));
                    break;
                case 1:
                    vehicles.add(factory.createVehicle(VehicleModelName.VOLVO));
                    break;
                case 2:
                    vehicles.add(factory.createVehicle(VehicleModelName.SCANIA));
                    break;
            }
        }
    }

    //TODO: WHy cant we remove the last car?
    public void removeCar() {
        if (vehicles.size() > 1) {
            vehicles.remove(vehicles.size() - 1);
        } else {
            vehicles.remove(0);
        }
    }

    public void createCarEvent(Vehicle v) {
        int x = (int) Math.round(v.getX());
        int y = (int) Math.round(v.getY());
        CarEvent currentCarEvent = new CarEvent(v.getCurrentSpeed(), x, y, v.getModelName());
        drawingObjects.add(currentCarEvent);
    }

    public void clearDrawingObjects() {
        drawingObjects = new ArrayList<>();
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

    public void notifyListeners() {
        for (ICarEventListener l : listeners) {
            l.update(drawingObjects);
        }
    }
}
