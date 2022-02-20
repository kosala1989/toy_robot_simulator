package com.simulate.toyrobot;

public class ToyRobot {

    private Position currentPosition;

    public ToyRobot() {
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getCurrentPosition() throws ToyRobotSimulatorException {
        if(null == currentPosition){
            throw new ToyRobotSimulatorException("Please PLACE the Robot first");
        }
        return currentPosition;
    }

    public void left() throws ToyRobotSimulatorException {
        Direction currentDirection = getCurrentPosition().getDirection();
        this.currentPosition.setDirection(Direction.valueOf(currentDirection.getLeft()));
    }
    public void right() throws ToyRobotSimulatorException {
        Direction currentDirection = getCurrentPosition().getDirection();
        this.currentPosition.setDirection(Direction.valueOf(currentDirection.getRight()));
    }

    public String reportPosition() {
        return this.currentPosition.getX() +
                "," +
                this.currentPosition.getY() +
                "," +
                this.currentPosition.getDirection().toString();
    }

}
