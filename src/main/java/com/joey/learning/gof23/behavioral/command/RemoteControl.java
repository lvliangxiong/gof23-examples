package com.joey.learning.gof23.behavioral.command;

import lombok.extern.slf4j.Slf4j;

/**
 * Invoker
 */
@Slf4j
public class RemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl(int slot) {
        onCommands = new Command[slot];
        offCommands = new Command[slot];
    }

    public void setOnCommand(int slot, Command command) {
        onCommands[slot] = command;
    }

    public void setOffCommand(int slot, Command command) {
        offCommands[slot] = command;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }
}
