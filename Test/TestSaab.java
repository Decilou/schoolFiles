import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestSaab {

    private Saab95 testSaab;
    private Saab95 testSaab2;

    @Before
    public void init() {
        testSaab = new Saab95(Color.red);
        testSaab2 = new Saab95(Color.black);


        testSaab.startEngine();

    }

    // -------------------- DECREMENT SPEED --------------------


    @Test
    public void decrementSpeedTestIfMaximumIsChosenEngineOff() {

        testSaab.stopEngine();

        assertTrue(testSaab.getCurrentSpeed() == 0);

    }

    @Test
    public void decrementSpeedTestIfMaximumIsChosenEngineOn() {

        assertTrue(testSaab.getCurrentSpeed() > 0 && testSaab.getCurrentSpeed() < 100);

    }

    @Test
    public void decrementSpeedTestThatTheSpeedDecreases () {

        testSaab.gas(1);

        double before = testSaab.getCurrentSpeed();

        testSaab.brake(1);

        double after = testSaab.getCurrentSpeed();

        assertTrue(before > after);

    }


    // -------------------- INCREMENT SPEED --------------------

    @Test
    public void incrementSpeedTestIfMinimumIsChosenEngineOff() {

        testSaab.stopEngine();

        assertTrue(testSaab.getCurrentSpeed() == 0);


    }

    @Test
    public void incrementSpeedTestIfMinimumIsChosenEngineOn() {

        assertTrue(testSaab.getCurrentSpeed() > 0 && testSaab.getCurrentSpeed() < 100);

    }

    @Test
    public void incrementSpeedTestThatTheSpeedIncreases() {

        double before = testSaab.getCurrentSpeed();

        testSaab.gas(1);

        double after = testSaab.getCurrentSpeed();

        assertTrue(before < after);

    }

    // -------------------- MOVE --------------------

    @Test
    public void moveTestIfCarIsFacingRIGHT () {

        assertTrue(testSaab.getCurrentDirection() == Direction.RIGHT);

    }

    @Test
    public void moveTestIfMethodDoesNothingWhenEngineIsOf () {

        testSaab.stopEngine();

        double before = testSaab.getX();

        testSaab.move();

        double after = testSaab.getX();

        assertTrue(before == after);

    }

    @Test
    public void moveTestIfCarMovesRIGHT () {

        double before = testSaab.getX();

        testSaab.startEngine();

        testSaab.move();

        double after = testSaab.getX();

        assertTrue(before < after);

    }

    @Test
    public void moveTestIfCarMovesLEFT () {

        testSaab = new Saab95(Color.red, Direction.LEFT);

        double before = testSaab.getX();

        testSaab.startEngine();

        testSaab.move();

        double after = testSaab.getX();

        assertTrue(before > after);

    }

    @Test
    public void moveTestIfCarMovesUP () {

        testSaab = new Saab95(Color.red, Direction.UP);

        double before = testSaab.getY();

        testSaab.startEngine();

        testSaab.move();

        double after = testSaab.getY();

        assertTrue(before > after);

    }

    @Test
    public void moveTestIfCarMovesDOWN () {

        testSaab = new Saab95(Color.red, Direction.DOWN);

        double before = testSaab.getY();

        testSaab.startEngine();

        testSaab.move();

        double after = testSaab.getY();

        assertTrue(before < after);

    }

    // -------------------- TURN RIGHT --------------------

    @Test
    public void turnRightTestDirectionChange () {

        testSaab.turnRight();

        assertTrue(testSaab.getCurrentDirection() == Direction.DOWN);

    }

    @Test
    public void turnRightTestOfALoop() {

        testSaab.turnRight();
        testSaab.turnRight();
        testSaab.turnRight();
        testSaab.turnRight();


        assertTrue(testSaab.getCurrentDirection() == Direction.RIGHT);

    }

    // -------------------- TURN LEFT --------------------

    @Test
    public void turnLeftTestDirectionChange () {

        testSaab.turnLeft();

        assertTrue(testSaab.getCurrentDirection() == Direction.UP);

    }

    @Test
    public void turnLeftTestOfALoop() {

        testSaab.turnLeft();
        testSaab.turnLeft();
        testSaab.turnLeft();
        testSaab.turnLeft();


        assertTrue(testSaab.getCurrentDirection() == Direction.RIGHT);

    }

    // -------------------- SPEED FACTOR --------------------

    @Test
    public void speedFactorTestIfSaabTurboOnChangesSpeedFactor () {

        double before = testSaab.speedFactor();

        testSaab.setTurboOn();

        double after = testSaab.speedFactor();

        assertTrue(before < after);

    }

    @Test
    public void speedFactorTestIfSaabTurboOffChangesSpeedFactor () {

        testSaab.setTurboOn();

        double before = testSaab.speedFactor();

        testSaab.setTurboOff();


        double after = testSaab.speedFactor();

        assertTrue(before > after);

    }

    // -------------------- GETTERS AND SETTERS --------------------

    @Test
    public void gettersAndSettersTestOfGetColor (){

        assertTrue(testSaab.getColor() != testSaab2.getColor() );

    }

    @Test
    public void gettersAndSettersTestOfGetNumberOfDoors(){

        assertTrue(testSaab.getNrDoors() == testSaab2.getNrDoors() );

    }

/*    @Test
    public void testOfToString(){

        assertTrue(testVolvo.toString().contains("volvo"));

    }*/


}
