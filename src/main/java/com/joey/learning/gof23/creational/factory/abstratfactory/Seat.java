package com.joey.learning.gof23.creational.factory.abstratfactory;


import lombok.extern.slf4j.Slf4j;

public interface Seat {
    void massage();
}

@Slf4j
class LuxurySeat implements Seat {

    @Override
    public void massage() {
        log.info("可以自动按摩！");
    }

}

@Slf4j
class CheapSeat implements Seat {

    @Override
    public void massage() {
        log.info("不能按摩！");
    }

}