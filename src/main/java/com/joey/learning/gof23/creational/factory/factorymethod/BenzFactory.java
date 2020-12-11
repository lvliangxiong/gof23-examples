package com.joey.learning.gof23.creational.factory.factorymethod;

public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Benz();
    }
}
