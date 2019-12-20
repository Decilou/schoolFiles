package Model;

import java.util.Random;

import java.util.ArrayList;

public class CarModel {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    VehicleFactory factory;

    public CarModel() {
        factory = new VehicleFactory();
        vehicles.add(factory.createVehicle(VehicleModelName.SAAB));
        vehicles.add(factory.createVehicle(VehicleModelName.VOLVO));
        vehicles.add(factory.createVehicle(VehicleModelName.SCANIA));
    }

    public void addRandomCar(){
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

    public void removeCar(){
        if (vehicles.size() > 0) {
            vehicles.remove(vehicles.size());
        }
    }

    public CarEvent createCarEvent(Vehicle v) {
        int x = (int) Math.round(v.getX());
        int y = (int) Math.round(v.getY());
        return new CarEvent(v.getCurrentSpeed(), x, y, v.getModelName());
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
}
