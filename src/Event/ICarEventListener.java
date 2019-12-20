package Event;

import Model.CarEvent;

public interface ICarEventListener {
    void update(CarEvent currentCarEvent);
}
