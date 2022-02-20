package com.simulate.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    public void testLeftAndRightDirection_NORTH() {
        Direction direction = Direction.NORTH;
        assertAll("left and right of NORTH direction should be WEST, EAST",
                () -> assertEquals(Direction.WEST.name(), direction.getLeft()),
                () -> assertEquals(Direction.EAST.name(), direction.getRight())
        );
    }
    @Test
    public void testLeftAndRightDirection_EAST() {
        Direction direction = Direction.EAST;
        assertAll("left and right of EAST direction should be NORTH, SOUTH",
                () -> assertEquals(Direction.NORTH.name(), direction.getLeft()),
                () -> assertEquals(Direction.SOUTH.name(), direction.getRight())
        );
    }
    @Test
    public void testLeftAndRightDirection_SOUTH() {
        Direction direction = Direction.SOUTH;
        assertAll("left and right of SOUTH direction should be EAST, WEST",
                () -> assertEquals(Direction.EAST.name(), direction.getLeft()),
                () -> assertEquals(Direction.WEST.name(), direction.getRight())
        );
    }
    @Test
    public void testLeftAndRightDirection_WEST() {
        Direction direction = Direction.WEST;
        assertAll("left and right of WEST direction should be SOUTH, NORTH",
                () -> assertEquals(Direction.SOUTH.name(), direction.getLeft()),
                () -> assertEquals(Direction.NORTH.name(), direction.getRight())
        );
    }
}