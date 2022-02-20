package com.simulate.toyrobot;

public class ToyRobotSimulator {

    private ToyRobot toyRobot;
    private Table table;

    public ToyRobotSimulator(ToyRobot toyRobot, Table table) {
        this.toyRobot = toyRobot;
        this.table = table;
    }

    public String executeCommand(String inputCommand) throws ToyRobotSimulatorException {
        String[] commands = inputCommand.split(" ");
        Command command = Command.validateCommand(commands[0]);
        String result = null;

        switch (command) {
            case PLACE:
                placeRobot(command, commands);
                break;
            case MOVE:
                Position nextPosition = this.toyRobot.getCurrentPosition().getNextPosition();
                if (this.table.isValidMove(nextPosition)) {
                    this.toyRobot.setCurrentPosition(nextPosition);
                }
                break;
            case REPORT:
                result = this.toyRobot.reportPosition();
                break;
            case RIGHT:
                this.toyRobot.right();
                break;
            case LEFT:
                this.toyRobot.left();
                break;
            default:
                throw new ToyRobotSimulatorException("Not supported");
        }
        return result;

    }

    private void placeRobot(Command command, String[] inputCommands) throws ToyRobotSimulatorException {

        String[] commandParams;
        if (command == Command.PLACE) {
            try {
                commandParams = inputCommands[1].split(",");

                int xAxis = Integer.parseInt(commandParams[0]);
                int yAxis = Integer.parseInt(commandParams[1]);
                Direction direction = Direction.valueOf(commandParams[2]);
                Position startPosition = new Position(xAxis, yAxis, direction);

                if (!this.table.isValidMove(startPosition)) {
                    throw new ToyRobotSimulatorException("X | Y coordinates are not supported.");
                }
                this.toyRobot.setCurrentPosition(startPosition);

            } catch (ToyRobotSimulatorException e) {
                throw e;
            } catch (Exception e) {
                throw new ToyRobotSimulatorException("Error while PLACE Robot. Please re-check command parameters");
            }
        }
    }
}
