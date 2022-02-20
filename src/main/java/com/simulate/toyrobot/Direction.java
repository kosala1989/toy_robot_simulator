package com.simulate.toyrobot;

public enum Direction {

    NORTH ("WEST", "EAST"),
    EAST ("NORTH", "SOUTH"),
    SOUTH ("EAST", "WEST"),
    WEST ("SOUTH", "NORTH");

    private final String right;
    private final String left;

    private Direction(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String getRight() {
        return right;
    }

    public String getLeft() {
        return left;
    }
}
