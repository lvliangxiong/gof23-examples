package com.joey.learning.gof23.creational.factory.factorymethod;

import org.junit.jupiter.api.Test;

class CarFactoryTest {

    @Test
    void createCar() {
        Car c1 = new AudiFactory().createCar();
        Car c2 = new BydFactory().createCar();
        c1.run();
        c2.run();

        Car c3 = new BenzFactory().createCar();
        c3.run();
    }
}