package Model;

import java.util.ArrayList;

public class CarModel {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private World world;

    public CarModel() {
        world = new World();
        VehicleFactory factory = new VehicleFactory();
        vehicles.add(factory.getVehicle(ModelNames.SAAB));
        vehicles.add(factory.getVehicle(ModelNames.VOLVO));
        vehicles.add(factory.getVehicle(ModelNames.SCANIA));
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
