package com.joey.learning.gof23.creational.factory.abstratfactory;

import lombok.extern.slf4j.Slf4j;

public interface Tyre {
    void revolve();
}

@Slf4j
class LuxuryTyre implements Tyre {

    @Override
    public void revolve() {
        log.info("旋转不磨损！");
    }

}

@Slf4j
class CheapTyre implements Tyre {

    @Override
    public void revolve() {
        log.info("旋转磨损快！");
    }

}