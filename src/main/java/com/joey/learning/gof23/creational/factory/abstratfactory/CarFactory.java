package com.joey.learning.gof23.creational.factory.abstratfactory;

public interface CarFactory {
    Engine createEngine();

    Seat createSeat();

    Tyre createTyre();
}


