package com.joey.learning.gof23.creational.factory.abstratfactory;

public class CheapCarFactory implements CarFactory {

    @Override
    public Engine createEngine() {
        return new CheapEngine();
    }

    @Override
    public Seat createSeat() {
        return new CheapSeat();
    }

    @Override
    public Tyre createTyre() {
        return new CheapTyre();
    }
}