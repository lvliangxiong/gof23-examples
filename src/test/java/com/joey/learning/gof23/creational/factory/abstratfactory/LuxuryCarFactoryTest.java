package com.joey.learning.gof23.creational.factory.abstratfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuxuryCarFactoryTest {

    @Test
    void createEngine() {
        CarFactory factory = new LuxuryCarFactory();
        Engine e = factory.createEngine();
        e.run();
        e.start();
    }
}