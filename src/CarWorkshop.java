import java.util.ArrayList;
import java.util.List;

public class CarWorkshop<T extends Car> {
    //TODO: Parametrisk polymorfism. Upper bound for generic type.
    //TODO: AnimalShelter är exempel. <? extends Car>. Vi gör listan Covariant
    //TODO: Lista för cars.
    //TODO: JavaDoc och Tester för alla metoder.

    private List <T> carsInWorkshop; // List of all the cars that currently are in the workshop
    private final int maxNumberOfCars; // The max amount of cars that the workshop can hold.

    public CarWorkshop(int maxNumberOfCars) {
        this.carsInWorkshop = new ArrayList<>();
        this.maxNumberOfCars = maxNumberOfCars;
    }

    //-------------------- METHODS --------------------

    /**
     * Method for checking if the workshop is full.
     * @return
     */

    public boolean isFull (){

        return (carsInWorkshop.size() >= maxNumberOfCars);

    }

    /**
     * Method for putting cars in the workshop.
     * @param carToLoad is the car that we are trying to put in the workshop.
     */

    public void loadCarIntoWorkshop (T carToLoad){

        if (!isFull()){
            carsInWorkshop.add(carToLoad);
        } else{
            System.out.println("There is no space left in the workshop!");
            throw new IllegalCallerException("There is no space left in the workshop.");
        }

    }

    /**
     * A method for taking cars out from the workshop.
     * @param carToUnload the car we are searching for in the workshop.
     * @return if the car was present in the workshop it is what we will get.
     */

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
