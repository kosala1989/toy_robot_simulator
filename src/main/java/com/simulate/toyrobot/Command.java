package com.simulate.toyrobot;

public enum Command {
    PLACE,
    MOVE,
    RIGHT,
    LEFT,
    REPORT;

    public static Command validateCommand(String command) throws ToyRobotSimulatorException {
        try {
            return Command.valueOf(command);
        } catch(IllegalArgumentException e) {
            throw new ToyRobotSimulatorException("Invalid Command!");
        }
    }
}
