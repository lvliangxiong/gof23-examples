package com.joey.learning.gof23.creational.factory.simplefactory;

import org.junit.jupiter.api.Test;

class CarSimpleFactoryTest {

    @Test
    void run() {
        // 普通模式创建对象，调用者需要直接和实现类进行交互，需要使用 new 操作
        Car c1 = new Audi();
        Car c2 = new Byd();
        c1.run();
        c2.run();

        // 工厂模式创建，调用者通过工厂进行所有操作，不直接和实现类打交道，简化调用者的操作
        Car c3 = CarSimpleFactory.createCar("Audi");
        Car c4 = CarSimpleFactory.createCar("Byd");
        c3.run();
        c4.run();
    }
}