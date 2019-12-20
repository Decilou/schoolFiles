package Model;

import java.awt.*;

class VehicleFactory {

    //TODO: Replace this y-counter with list.size()*100
    int y = 0;
    Vehicle createVehicle(VehicleModelName name) {

        if (name == null) {
            return null;
        } else if (name.equals(VehicleModelName.SAAB)) {
            y = y + 100;
            return new Saab95(Color.black, 10, y);

        } else if (name.equals(VehicleModelName.VOLVO)) {
            y = y + 100;
            return new Volvo240(Color.gray, 10, y);

        } else if (name.equals(VehicleModelName.SCANIA)) {
            y = y + 100;
            return new Scania(Color.red, 10, y);
        }
        return null;
    }
}
