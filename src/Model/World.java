package Model;

public class World {

    private static final int X = 800;
    private static final int Y = 800;


    //TODO: Why should they be static? Should they not be?
    public static int getWorldX() {
        return X;
    }

    public static int getWorldY() {
        return Y;
    }
}
