package com.joey.learning.gof23.structural.bridge;

import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void sale() {
        Computer c = new Desktop(new Asus());
        c.sale();
    }
}