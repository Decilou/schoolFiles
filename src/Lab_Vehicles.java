import java.awt.*;
import static java.lang.System.out;

public class Lab_Vehicles {

    public static void main(String[] args) {

       Saab95 saab = new Saab95(2, 125, 0, Color.red, "Saab95",0,0,0);
        Volvo240 volvo = new Volvo240(4, 100, 0, Color.red,"Volvo240",0,0,0);

        saab.startEngine();
        out.println(saab.getX() + "  |  " + saab.getCurrentSpeed());
        saab.move();
        saab.gas(1);

        out.println(saab.getX() + "  |  " + saab.getCurrentSpeed());

        saab.brake(1);
        out.println(saab.getX() + "  |  " + saab.getCurrentSpeed());

        saab.brake(1);

        out.println(saab.getX() + "  |  " + saab.getCurrentSpeed());






    }


}
