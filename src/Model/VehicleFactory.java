package Model;

import java.awt.*;

class VehicleFactory {

    Vehicle createVehicle(VehicleModelName name) {

        if (name == null) {
            return null;
        } else if (name.equals(VehicleModelName.SAAB)) {
            return new Saab95(Color.black, 10, 10);

        } else if (name.equals(VehicleModelName.VOLVO)) {
            return new Volvo240(Color.gray, 10, 110);

        } else if (name.equals(VehicleModelName.SCANIA)) {
            return new Scania(Color.red, 10, 210);
        }
        return null;
    }
}
