package com.joey.learning.gof23.structural.facade;

public class Facade {
    private SubSystem subSystem = new SubSystem();

    public void watchMovie(String cd) {
        subSystem.turnOnTv();
        subSystem.setCD(cd);
        subSystem.startWatching();
    }
}
