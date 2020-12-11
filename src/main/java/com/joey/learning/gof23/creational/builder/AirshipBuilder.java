package com.joey.learning.gof23.creational.builder;

public interface AirshipBuilder {
    Engine buildEngine();

    OrbitalModule BuildOrbitalModule();

    EscapeTower buildEscapeTower();
}
