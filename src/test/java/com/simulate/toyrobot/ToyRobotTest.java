package com.simulate.toyrobot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyRobotTest {

    private ToyRobot toyRobot;
    private Position startPosition;

    @BeforeEach
    public void setup(){
        this.startPosition = new Position(0, 0, Direction.NORTH);
        this.toyRobot = new ToyRobot();
    }
    @Test
    public void toyRobotShouldAbleToUpdateNextPosition() throws ToyRobotSimulatorException {
        //update new position
        toyRobot.setCurrentPosition(startPosition);
        assertEquals(startPosition, toyRobot.getCurrentPosition());
    }
    @Test
    public void shouldThrowExceptionWhenPositionIsNotSet() {
        assertThrows(ToyRobotSimulatorException.class, () -> toyRobot.getCurrentPosition());
    }

    @Test
    public void shouldAbleToRotateLeft() throws ToyRobotSimulatorException {
        toyRobot.setCurrentPosition(startPosition);
        assertEquals(Direction.NORTH, toyRobot.getCurrentPosition().getDirection());
        toyRobot.left();
        assertEquals(Direction.WEST, toyRobot.getCurrentPosition().getDirection());
    }

    @Test
    public void shouldAbleToRotateRight() throws ToyRobotSimulatorException {
        toyRobot.setCurrentPosition(startPosition);
        assertEquals(Direction.NORTH, toyRobot.getCurrentPosition().getDirection());
        toyRobot.right();
        assertEquals(Direction.EAST, toyRobot.getCurrentPosition().getDirection());
    }

    @Test
    public void shouldAbleToRotateMultipleTimes() throws ToyRobotSimulatorException {
        toyRobot.setCurrentPosition(startPosition);
        assertEquals(Direction.NORTH, toyRobot.getCurrentPosition().getDirection());
        toyRobot.right();
        toyRobot.right();
        assertEquals(Direction.SOUTH, toyRobot.getCurrentPosition().getDirection());
        toyRobot.left();
        assertEquals(Direction.EAST, toyRobot.getCurrentPosition().getDirection());
    }

    @Test
    public void shouldAblePrintPosition() throws ToyRobotSimulatorException {
        toyRobot.setCurrentPosition(startPosition);
        String expectedLocation = "0,0,NORTH";
        assertEquals(expectedLocation, toyRobot.reportPosition());
    }

}