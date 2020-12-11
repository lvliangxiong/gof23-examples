package com.joey.learning.gof23.structural.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    @Test
    void watchMovie() {
        Facade facade = new Facade();
        facade.watchMovie("a movie");
    }
}