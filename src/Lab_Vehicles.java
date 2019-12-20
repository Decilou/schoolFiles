import Controller.CarController;
import View.CarView;
import Model.CarModel;
import View.DrawPanel;
import View.SpeedView;

public class Lab_Vehicles {

    public static void main(String[] args) {

        //Create model, view, controller.
        CarModel model = new CarModel();
        DrawPanel drawPanel = new DrawPanel(model.getWorldX(), model.getWorldY() - 240);
        CarView frame = new CarView("CarSim 1.0", drawPanel, model.getWorldX(), model.getWorldY());
        SpeedView speed = new SpeedView("A need for speed");
        CarController controller = new CarController(frame, model);

        controller.addListener(drawPanel);
        frame.addListener(controller);
        controller.addListener(speed);
    }
}
