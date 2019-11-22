import java.util.ArrayList;
import java.util.List;

public class CarWorkshop<T extends Car> {
    //TODO: Parametrisk polymorfism. Upper bound for generic type.
    //TODO: AnimalShelter är exempel. <? extends Car>. Vi gör listan Covariant
    //TODO: Lista för cars.
    //TODO: JavaDoc och Tester för alla metoder.

    private List <T> carsInWorkshop;
    private int maxNumberOfCars;

    public CarWorkshop(List<T> carsInWorkshop, int maxNumberOfCars) {
        this.carsInWorkshop = new ArrayList<>();
        this.maxNumberOfCars = maxNumberOfCars;
    }
    
    public boolean isFull (){

        return (carsInWorkshop.size() >= maxNumberOfCars);

    }

    public void loadCarIntoWorkshop (T carToLoad){

        if (!isFull()){
            carsInWorkshop.add(carToLoad);
        } else{
            System.out.println("There is no space left in the workshop!");
            throw new IllegalCallerException("There is no space left in the workshop.");
        }

    }

    public T unloadCarFromWorkshop (T carToUnload) {

        if (!carsInWorkshop.isEmpty() && carsInWorkshop.contains(carToUnload)){
            carsInWorkshop.remove(carToUnload);
            return carToUnload;
        } else {
            System.out.println("Your car is not in the workshop");
            throw new IllegalCallerException("Your car is not in the workshop");
        }
    }


}
