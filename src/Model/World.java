package Model;

class World {

    private static final int X = 800;
    private static final int Y = 800;


    //TODO: Why should they be static? Should they not be?
    static int getWorldX() {
        return X;
    }

    static int getWorldY() {
        return Y;
    }
}
