package com.joey.learning.gof23.creational.factory.simplefactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Byd implements Car {
    @Override
    public void run() {
        log.info("Byd is running ...");
    }
}
