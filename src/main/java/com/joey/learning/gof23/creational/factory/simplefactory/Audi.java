package com.joey.learning.gof23.creational.factory.simplefactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Audi implements Car {
    @Override
    public void run() {
        log.info("Audi is running ...");
    }
}
