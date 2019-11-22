import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestVolvo {

    private Volvo240 testVolvo;
    private Volvo240 testVolvo2;

    @Before
    public void init() {
        testVolvo = new Volvo240(Color.red);
        testVolvo2 = new Volvo240(Color.black);


        testVolvo.startEngine();

    }

    // -------------------- DECREMENT SPEED --------------------


    @Test
    public void decrementSpeedTestIfMaximumIsChosenEngineOff() {

        testVolvo.stopEngine();

        assertTrue(testVolvo.getCurrentSpeed() == 0);

    }

    @Test
    public void decrementSpeedTestIfMaximumIsChosenEngineOn() {

        assertTrue(testVolvo.getCurrentSpeed() > 0 && testVolvo.getCurrentSpeed() < 100);

    }

    @Test
    public void decrementSpeedTestThatTheSpeedDecreases () {

        testVolvo.gas(1);

        double before = testVolvo.getCurrentSpeed();

        testVolvo.brake(1);

        double after = testVolvo.getCurrentSpeed();

        assertTrue(before > after);

    }


    // -------------------- INCREMENT SPEED --------------------

    @Test
    public void incrementSpeedTestIfMinimumIsChosenEngineOff() {

        testVolvo.stopEngine();

        assertTrue(testVolvo.getCurrentSpeed() == 0);


    }

    @Test
    public void incrementSpeedTestIfMinimumIsChosenEngineOn() {

        assertTrue(testVolvo.getCurrentSpeed() > 0 && testVolvo.getCurrentSpeed() < 100);

    }

    @Test
    public void incrementSpeedTestThatTheSpeedIncreases() {

        double before = testVolvo.getCurrentSpeed();

        testVolvo.gas(1);

        double after = testVolvo.getCurrentSpeed();

        assertTrue(before < after);

    }

    // -------------------- MOVE --------------------

    @Test
    public void moveTestIfCarIsFacingRIGHT () {

        assertTrue(testVolvo.getCurrentDirection() == Direction.RIGHT);

    }

    @Test
    public void moveTestIfMethodDoesNothingWhenEngineIsOf () {

        testVolvo.stopEngine();

        double before = testVolvo.getX();

        testVolvo.move();

        double after = testVolvo.getX();

        assertTrue(before == after);

    }

    @Test
    public void moveTestIfCarMovesRIGHT () {

        double before = testVolvo.getX();

        testVolvo.startEngine();

        testVolvo.move();

        double after = testVolvo.getX();

        assertTrue(before < after);

    }

    @Test
    public void moveTestIfCarMovesLEFT () {

        testVolvo = new Volvo240(Color.red, Direction.LEFT);

        double before = testVolvo.getX();

        testVolvo.startEngine();

        testVolvo.move();

        double after = testVolvo.getX();

        assertTrue(before > after);

    }

    @Test
    public void moveTestIfCarMovesUP () {

        testVolvo.turnLeft();

        double before = testVolvo.getY();

        testVolvo.startEngine();

        testVolvo.move();

        double after = testVolvo.getY();

        assertTrue(before > after);

    }

    @Test
    public void moveTestIfCarMovesDOWN () {

        testVolvo.turnRight();

        double before = testVolvo.getY();

        testVolvo.startEngine();

        testVolvo.move();

        double after = testVolvo.getY();

        assertTrue(before < after);

    }

    // -------------------- TURN RIGHT --------------------

    @Test
    public void turnRightTestDirectionChange () {

        testVolvo.turnRight();

        assertTrue(testVolvo.getCurrentDirection() == Direction.DOWN);

    }

    @Test
    public void turnRightTestOfALoop() {

        testVolvo.turnRight();
        testVolvo.turnRight();
        testVolvo.turnRight();
        testVolvo.turnRight();


        assertTrue(testVolvo.getCurrentDirection() == Direction.RIGHT);

    }

    // -------------------- TURN LEFT --------------------

    @Test
    public void turnLeftTestDirectionChange () {

        testVolvo.turnLeft();

        assertTrue(testVolvo.getCurrentDirection() == Direction.UP);

    }

    @Test
    public void turnLeftTestOfALoop() {

        testVolvo.turnLeft();
        testVolvo.turnLeft();
        testVolvo.turnLeft();
        testVolvo.turnLeft();


        assertTrue(testVolvo.getCurrentDirection() == Direction.RIGHT);

    }

    // -------------------- SPEED FACTOR --------------------
    /*

    @Test
    public void speedFactorTestIfEnginePowerChangesSpeedFactor () {

        assertTrue(testVolvo.speedFactor() > testVolvo.speedFactor());

    }
    */

    // -------------------- GETTERS AND SETTERS --------------------

    @Test
    public void gettersAndSettersTestOfGetColor (){

        assertTrue(testVolvo.getColor() != testVolvo2.getColor() );

    }

    @Test
    public void gettersAndSettersTestOfGetNumberOfDoors(){

        assertTrue(testVolvo.getNrDoors() == testVolvo2.getNrDoors() );

    }

/*    @Test
    public void testOfToString(){

        assertTrue(testVolvo.toString().contains("volvo"));

    }*/








}
