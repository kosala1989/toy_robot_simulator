package com.simulate.toyrobot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyRobotSimulatorTest {

    private ToyRobotSimulator simulator;
    private Table table;
    private ToyRobot toyRobot;

    @BeforeEach
    public void setup() {
        this.table = new Table(5, 5);
        this.toyRobot = new ToyRobot();
        this.simulator = new ToyRobotSimulator(toyRobot, table);
    }

    @Test
    public void shouldThrowErrorExecuteInvalidCommand() {
       assertThrows(ToyRobotSimulatorException.class, ()-> simulator.executeCommand("ABC"));
    }

    @Test
    public void shouldThrowErrorWhenExecuteMoveCommandBeforePlaceCommand() {
        assertThrows(ToyRobotSimulatorException.class, ()-> simulator.executeCommand("MOVE"));
    }
    @Test
    public void shouldThrowErrorWhenExecuteRotateCommandsBeforePlaceCommand() {
        assertAll("should throw exception when execute LEFT/RIGHT rotate commands before execute PLACE",
                () -> assertThrows(ToyRobotSimulatorException.class, ()-> simulator.executeCommand("LEFT")),
                () -> assertThrows(ToyRobotSimulatorException.class, ()-> simulator.executeCommand("RIGHT"))

        );
    }
    @Test
    public void shouldThrowErrorWhenExecuteReportCommandBeforePlaceCommand() {
        assertThrows(ToyRobotSimulatorException.class, ()-> simulator.executeCommand("REPORT"));
    }

    @Test
    public void verifyPlaceCommand() throws ToyRobotSimulatorException {
       String placeCommand = "PLACE 0,0,NORTH";
       String expectedLocation = "0,0,NORTH";
       simulator.executeCommand(placeCommand);
       String answer = simulator.executeCommand("REPORT");

       assertEquals(expectedLocation, answer);

    }

    @Test
    public void verifyLeftCommand() throws ToyRobotSimulatorException {
        String placeCommand = "PLACE 0,0,NORTH";
        String expectedLocation = "0,0,WEST";
        simulator.executeCommand(placeCommand);
        simulator.executeCommand("LEFT");
        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);

    }
    @Test
    public void verifyRightCommand() throws ToyRobotSimulatorException {
        String placeCommand = "PLACE 0,0,NORTH";
        String expectedLocation = "0,0,EAST";
        simulator.executeCommand(placeCommand);
        simulator.executeCommand("RIGHT");
        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);

    }
    @Test
    public void verifyMoveCommand() throws ToyRobotSimulatorException {
        String placeCommand = "PLACE 0,0,NORTH";
        String expectedLocation = "0,1,NORTH";
        simulator.executeCommand(placeCommand);
        simulator.executeCommand("MOVE");
        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);

    }
    @Test
    public void verifyRobotMoveWithinBoard_lowerX() throws ToyRobotSimulatorException {

        simulator.executeCommand("PLACE 0,0,WEST");
        simulator.executeCommand("MOVE");
        //Robot can move only within table width & height range
        String expectedLocation = "0,0,WEST";

        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);

    }

    @Test
    public void verifyRobotMoveWithinBoard_upperX() throws ToyRobotSimulatorException {

        simulator.executeCommand("PLACE 0,0,EAST");
        //move 6 positions to right
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        //Robot can move only within table width & height range
        String expectedLocation = "5,0,EAST";

        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);
    }

    @Test
    public void verifyRobotMoveWithinBoard_lowerY() throws ToyRobotSimulatorException {

        simulator.executeCommand("PLACE 0,0,SOUTH");
        simulator.executeCommand("MOVE");
        //Robot can move only within table width & height range
        String expectedLocation = "0,0,SOUTH";

        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);

    }

    @Test
    public void verifyRobotMoveWithinBoard_upperY() throws ToyRobotSimulatorException {

        simulator.executeCommand("PLACE 0,0,NORTH");
        //move 6 positions to right
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        //Robot can move only within table width & height range
        String expectedLocation = "0,5,NORTH";

        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);
    }

    @Test
    public void verifySequenceOfCommands_1() throws ToyRobotSimulatorException {
        simulator.executeCommand("PLACE 0,0,NORTH");
        simulator.executeCommand("RIGHT");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        String expectedLocation = "2,0,EAST";

        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);

    }

    @Test
    public void verifySequenceOfCommands_2() throws ToyRobotSimulatorException {
        simulator.executeCommand("PLACE 0,0,NORTH");
        simulator.executeCommand("LEFT");
        String expectedLocation = "0,0,WEST";

        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);

    }

    @Test
    public void verifySequenceOfCommands_3() throws ToyRobotSimulatorException {
        simulator.executeCommand("PLACE 1,2,EAST");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("MOVE");
        simulator.executeCommand("LEFT");
        simulator.executeCommand("MOVE");
        String expectedLocation = "3,3,NORTH";

        String answer = simulator.executeCommand("REPORT");
        assertEquals(expectedLocation, answer);

    }
}