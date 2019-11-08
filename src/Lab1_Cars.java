import java.awt.*;
import static java.lang.System.out;

public class Lab1_Cars {

    public static void main(String[] args) {

        Saab95 saab = new Saab95(2, 125, 0, Color.red, "Saab95");
        Volvo240 volvo = new Volvo240(4, 100, 0, Color.red,"Volvo240");

        out.println(saab.toString());
        out.println(volvo.toString());
    }
}
