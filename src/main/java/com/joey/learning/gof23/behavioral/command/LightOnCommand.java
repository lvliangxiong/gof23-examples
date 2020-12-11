package com.joey.learning.gof23.behavioral.command;

import lombok.extern.slf4j.Slf4j;

/**
 * Concrete Command
 */
@Slf4j
public class LightOnCommand implements Command{
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        log.info("light was on, before");
        light.on();
        log.info("light was on, after");
    }
}
