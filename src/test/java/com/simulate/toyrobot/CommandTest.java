package com.simulate.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CommandTest {

    @Test()
    public void throwWhenGivenCommandIsNotSupported() {
        assertThrows(ToyRobotSimulatorException.class, () -> Command.validateCommand("ABC"));
    }

    @Test
    public void shouldSupportAllValidCommands() {
        assertAll("Should support PLACE, MOVE, RIGHT, LEFT & REPORT commands",
                () ->  assertEquals(Command.PLACE, Command.validateCommand("PLACE")),
                () ->  assertEquals(Command.MOVE, Command.validateCommand("MOVE")),
                () ->  assertEquals(Command.RIGHT, Command.validateCommand("RIGHT")),
                () ->  assertEquals(Command.LEFT, Command.validateCommand("LEFT")),
                () ->  assertEquals(Command.REPORT, Command.validateCommand("REPORT"))
        );
    }

}