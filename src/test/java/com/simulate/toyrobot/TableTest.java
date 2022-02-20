package com.simulate.toyrobot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    private Table table;
    private int width;
    private int height;

    @BeforeEach
    public void setup() {
        this.height = 5;
        this.width = 5;
        this.table = new Table(width, height);
    }

    @Test
    public void shouldReturnFalseIfGivenPositionIsOutSideTable(){
        Position positionOutSideTable = new Position(6,6, Direction.NORTH);
       assertFalse(this.table.isValidMove(positionOutSideTable));
    }

    @Test
    public void shouldReturnTrueIfGivenPositionIsInSideTable(){
        Position positionOutSideTable = new Position(1,1, Direction.NORTH);
        assertTrue(this.table.isValidMove(positionOutSideTable));
    }

}