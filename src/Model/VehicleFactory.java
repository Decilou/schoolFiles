package Model;

import java.awt.*;
import java.util.ArrayList;

class VehicleFactory {

    private ArrayList<Vehicle> vehicles;
    private int y;

    VehicleFactory(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    Vehicle createVehicle(VehicleModelName name) {

        if (name == null) {
            return null;
        } else if (name.equals(VehicleModelName.SAAB)) {
            y = (vehicles.size() + 1) * 80;
            return new Saab95(Color.black, 10, y);

        } else if (name.equals(VehicleModelName.VOLVO)) {
            y = (vehicles.size() + 1) * 80;
            return new Volvo240(Color.gray, 10, y);

        } else if (name.equals(VehicleModelName.SCANIA)) {
            y = (vehicles.size() + 1) * 80;
            return new Scania(Color.red, 10, y);
        }
        return null;
    }


}
