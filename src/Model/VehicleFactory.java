package Model;

import java.awt.*;

class VehicleFactory {

    Vehicle createVehicle(VehicleModelName name) {

        int y = 0;

        if (name == null) {
            return null;
        } else if (name.equals(VehicleModelName.SAAB)) {
            y = y+10;
            return new Saab95(Color.black, 10, y);

        } else if (name.equals(VehicleModelName.VOLVO)) {
            y = y+10;
            return new Volvo240(Color.gray, 10, y);

        } else if (name.equals(VehicleModelName.SCANIA)) {
            y = y+10;
            return new Scania(Color.red, 10, y);
        }
        return null;
    }
}
