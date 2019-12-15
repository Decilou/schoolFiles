package Model;

import java.awt.*;

public class VehicleFactory {

    public Vehicle getVehicle(String modelType) {

        if (modelType == null) {
            return null;
        } else if (modelType.equalsIgnoreCase("SAAB")) {
            return new Saab95(Color.black, 10, 10);

        } else if (modelType.equalsIgnoreCase("VOLVO")) {
            return new Volvo240(Color.gray, 10, 110);

        } else if (modelType.equalsIgnoreCase("SCANIA")) {
            return new Scania(Color.red, 10, 210);
        }
        return null;
    }
}
