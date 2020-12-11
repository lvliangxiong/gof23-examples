package com.joey.learning.gof23.behavioral.command;

import org.junit.jupiter.api.Test;

class RemoteControlTest {
    private RemoteControl remote = new RemoteControl(5);
    private Light light = new Light();

    {
        remote.setOnCommand(0, new LightOnCommand(light));
        remote.setOffCommand(0, new LightOffCommand(light));
    }

    @Test
    void onButtonWasPushed() {
        remote.onButtonWasPushed(0);
    }

    @Test
    void offButtonWasPushed() {
        remote.offButtonWasPushed(0);
    }
}