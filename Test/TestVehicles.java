import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestVehicles {

    private Saab95 testSaab;
    private Volvo240 testVolvo;
    private Volvo240 testVolvo2;

    @Before
    public void init() {
        testSaab = new Saab95(4,100,0, Color.red, "saab",0,0,0);
        testVolvo = new Volvo240(4,100,0, Color.red, "volvo",0,0,0);
        testVolvo2 = new Volvo240(6,200,0, Color.black, "Mark",0,0,0);


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

        assertTrue(testVolvo.getCurrentDirection() == Direction.RIGHT);

    }

    @Test
    public void moveTestIfMethodDoesNothingWhenEngineIsOf () {

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

        testVolvo = new Volvo240(4,100,0, Color.red, "volvo", Direction.LEFT,0,0,0);

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
    public void turnLeftTestIfSaabTurboOnChangesSpeedFactor () {

        double before = testSaab.speedFactor();

        testSaab.setTurboOn();

        double after = testSaab.speedFactor();

        assertTrue(before < after);

    }

    @Test
    public void turnLeftTestIfSaabTurboOffChangesSpeedFactor () {

        testSaab.setTurboOn();

        double before = testSaab.speedFactor();

        testSaab.setTurboOff();


        double after = testSaab.speedFactor();

        assertTrue(before > after);

    }

    @Test
    public void turnLeftTestIfEnginePowerChangesSpeedFactor () {

        assertTrue(testVolvo2.speedFactor() > testVolvo.speedFactor());

    }

    // -------------------- GETTERS AND SETTERS --------------------

    @Test
    public void gettersAndSettersTestOfGetColor (){

        assertTrue(testVolvo.getColor() != testVolvo2.getColor() );

    }

    @Test
    public void gettersAndSettersTestOfGetNumberOfDoors(){

        assertTrue(testVolvo.getNrDoors() != testVolvo2.getNrDoors() );

    }

/*    @Test
    public void testOfToString(){

        assertTrue(testVolvo.toString().contains("volvo"));

    }*/








}
