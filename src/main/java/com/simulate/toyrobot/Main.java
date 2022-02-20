package com.simulate.toyrobot;

import java.util.Scanner;

public class Main {

    private static final int DEFAULT_WIDTH = 5;
    private static final int DEFAULT_HEIGHT = 5;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("*******   TOY ROBOT SIMULATOR ********");
        System.out.println("Please enter below commands to place and rome the robot ");
        System.out.println("\t1 - PLACE X,Y,F (To place robot on table).");
        System.out.println("\t2 - MOVE, LEFT, RIGHT (To move, rotate robot on the table)");
        System.out.println("\t3 - REPORT (print current location)");
        System.out.println("\t4 - EXIT (exit program");
        System.out.println("");

        boolean programAlive = true;
        Table surface = new Table(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        ToyRobot toyRobot = new ToyRobot();
        ToyRobotSimulator simulator = new ToyRobotSimulator(toyRobot, surface);

        while (programAlive) {
            String command = in.nextLine();
            if ("EXIT".equals(command)) {
                programAlive = false;
            } else {
                try {
                    String commandOut = simulator.executeCommand(command);
                    if (null != commandOut) {
                        System.out.println(commandOut);
                    }

                } catch (ToyRobotSimulatorException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
