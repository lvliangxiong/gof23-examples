package com.joey.learning.gof23.creational.factory.factorymethod;


public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
