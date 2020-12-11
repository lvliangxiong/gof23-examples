package com.joey.learning.gof23.structural.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubSystem {
    public void turnOnTv() {
        log.info("turn on tv");
    }

    public void setCD(String cd) {
        log.info("set CD: {}", cd);
    }

    public void startWatching() {
        log.info("start watching");
    }
}
