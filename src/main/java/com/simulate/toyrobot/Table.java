package com.simulate.toyrobot;

public class Table {
    private int width;
    private int height;

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isValidMove(Position nextPosition ) {
        return nextPosition.getX() >= 0 && nextPosition.getX() <= this.width
                && nextPosition.getY() >= 0 && nextPosition.getY() <= this.height;
    }
}
