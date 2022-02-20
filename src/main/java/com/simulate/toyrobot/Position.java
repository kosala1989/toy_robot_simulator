package com.simulate.toyrobot;

public class Position {

    private int xAxis;
    private int yAxis;
    private Direction direction;

    public Position(int xAxis, int yAxis, Direction direction) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.direction = direction;
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return this.xAxis;
    }

    public int getY() {
        return this.yAxis;
    }

    public Position getNextPosition() {

        Position newPosition = new Position(this.xAxis, this.yAxis, this.direction);
        switch (this.direction) {
            case NORTH:
                newPosition.changeLocation(0, 1);
                break;
            case EAST:
                newPosition.changeLocation(1, 0);
                break;
            case SOUTH:
                newPosition.changeLocation(0, -1);
                break;
            case WEST:
                newPosition.changeLocation(-1, 0);
                break;
        }
        return newPosition;
    }

    private void changeLocation(int changeX, int changeY) {
        this.xAxis += changeX;
        this.yAxis += changeY;
    }
}
