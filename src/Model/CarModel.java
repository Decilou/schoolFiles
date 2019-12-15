package Model;

import java.util.ArrayList;

public class CarModel {

    public ArrayList<Vehicle> vehicles = new ArrayList<>();

    private VehicleFactory factory;
    private World world;

    public CarModel() {
        world = new World();
        factory = new VehicleFactory();
        vehicles.add(factory.getVehicle("SAAB"));
        vehicles.add(factory.getVehicle("VOLVO"));
        vehicles.add(factory.getVehicle("SCANIA"));
    }

    public int getWorldX() {
        return world.getWorldX();
    }

    public int getWorldY() {
        return world.getWorldY();
    }



}
