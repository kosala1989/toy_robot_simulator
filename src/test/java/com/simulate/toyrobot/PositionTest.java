package com.simulate.toyrobot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {

    private Position startPosition;

    @BeforeEach
    public void setup(){
        int xAxis = 0;
        int yAxis = 0;
        Direction direction = Direction.NORTH;
        startPosition = new Position(xAxis, yAxis, direction);
    }

    @Test
    public void ableToUpdateNewDirection(){
        startPosition.setDirection(Direction.EAST);
        assertEquals(Direction.EAST, startPosition.getDirection());
    }

    @Test
    public void givenNorthDirectionNextPositionShouldIncrementYAxisValueByOne(){

        startPosition.setDirection(Direction.NORTH);
        int beforeXAxis = startPosition.getX();
        int beforeYAxis = startPosition.getY();

        Position nextPosition = startPosition.getNextPosition();

        assertAll("Y axis should increment by one and X axis should not change & start position should not change ",
                () -> assertEquals(beforeXAxis, nextPosition.getX()),
                () -> assertEquals(beforeYAxis+1, nextPosition.getY()),
                () -> assertEquals(beforeXAxis, startPosition.getX()),
                () -> assertEquals(beforeYAxis, startPosition.getY())
        );
    }
    @Test
    public void givenEastDirectionNextPositionShouldIncrementXAxisValueByOne(){

        startPosition.setDirection(Direction.EAST);
        int beforeXAxis = startPosition.getX();
        int beforeYAxis = startPosition.getY();

        Position nextPosition = startPosition.getNextPosition();

        assertAll("X axis should increment by one and Y axis should not change & start position should not change ",
                () -> assertEquals(beforeXAxis+1, nextPosition.getX()),
                () -> assertEquals(beforeYAxis, nextPosition.getY()),
                () -> assertEquals(beforeXAxis, startPosition.getX()),
                () -> assertEquals(beforeYAxis, startPosition.getY())
        );
    }
    @Test
    public void givenSouthDirectionNextPositionShouldDecrementYAxisValueByOne(){

        startPosition.setDirection(Direction.SOUTH);
        int beforeXAxis = startPosition.getX();
        int beforeYAxis = startPosition.getY();

        Position nextPosition = startPosition.getNextPosition();

        assertAll("Y axis should decrement by one and X axis should not change & start position should not change ",
                () -> assertEquals(beforeXAxis, nextPosition.getX()),
                () -> assertEquals(beforeYAxis - 1, nextPosition.getY()),
                () -> assertEquals(beforeXAxis, startPosition.getX()),
                () -> assertEquals(beforeYAxis, startPosition.getY())
        );
    }
    @Test
    public void givenWestDirectionNextPositionShouldDecrementXAxisValueByOne(){

        startPosition.setDirection(Direction.WEST);
        int beforeXAxis = startPosition.getX();
        int beforeYAxis = startPosition.getY();

        Position nextPosition = startPosition.getNextPosition();

        assertAll("X axis should decrement by one and Y axis should not change & start position should not change ",
                () -> assertEquals(beforeXAxis-1, nextPosition.getX()),
                () -> assertEquals(beforeYAxis, nextPosition.getY()),
                () -> assertEquals(beforeXAxis, startPosition.getX()),
                () -> assertEquals(beforeYAxis, startPosition.getY())
        );
    }
}