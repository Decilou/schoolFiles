package Model;

import java.util.ArrayList;

public class CarModel {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private World world;

    public CarModel() {
        world = new World();
        VehicleFactory factory = new VehicleFactory();
        vehicles.add(factory.createVehicle(VehicleModelName.SAAB));
        vehicles.add(factory.createVehicle(VehicleModelName.VOLVO));
        vehicles.add(factory.createVehicle(VehicleModelName.SCANIA));
    }

    public int getWorldX() {
        return world.getWorldX();
    }

    public int getWorldY() {
        return world.getWorldY();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
