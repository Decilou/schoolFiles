package Model;

/**
 * Contract for movable objects.
 */

public interface IMovable {


    /**
     * Moves the object.
     */
    void move();

    /**
     * Changes direction counterclockwise.
     */
    void turnLeft();

    /**
     * Changes direction clockwise.
     */
    void turnRight();

}
