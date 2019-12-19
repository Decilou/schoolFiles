package Model;
import jdk.jshell.execution.Util;

import java.util.Random;

import java.util.ArrayList;

public class CarModel {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private World world;

    VehicleFactory factory;

    public CarModel() {
        world = new World();
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

    public ArrayList createNameList(){

        ArrayList<String> vehiclesNames = new ArrayList<>();

        for (Vehicle v: vehicles){
            vehiclesNames.add(v.getModelName());
        }
        return vehiclesNames;
    }



    public int getWorldX() {
        return World.getWorldX();
    }

    public int getWorldY() {
        return World.getWorldY();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
