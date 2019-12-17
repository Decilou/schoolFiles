package Model;

import java.awt.*;

class VehicleFactory {

    Vehicle getVehicle(ModelNames names) {

        if (names == null) {
            return null;
        } else if (names.equals(ModelNames.SAAB)) {
            return new Saab95(Color.black, 10, 10);

        } else if (names.equals(ModelNames.VOLVO)) {
            return new Volvo240(Color.gray, 10, 110);

        } else if (names.equals(ModelNames.SCANIA)) {
            return new Scania(Color.red, 10, 210);
        }
        return null;
    }
}
