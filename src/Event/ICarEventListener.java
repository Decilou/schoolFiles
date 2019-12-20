package Event;

import Model.CarEvent;

import java.util.ArrayList;

public interface ICarEventListener {
    void update(ArrayList<CarEvent> drawingObjects);
}
