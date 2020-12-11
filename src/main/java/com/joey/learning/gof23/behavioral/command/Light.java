package com.joey.learning.gof23.behavioral.command;

import lombok.extern.slf4j.Slf4j;

/**
 * Receiver
 */
@Slf4j
public class Light {
    public void on() {
        log.info("Light On");
    }

    public void off() {
        log.info("Light Off");
    }
}
