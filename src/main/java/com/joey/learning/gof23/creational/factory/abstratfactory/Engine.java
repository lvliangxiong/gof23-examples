package com.joey.learning.gof23.creational.factory.abstratfactory;

import lombok.extern.slf4j.Slf4j;

public interface Engine {
    void run();

    void start();
}

@Slf4j
class LuxuryEngine implements Engine {

    @Override
    public void run() {
        log.info("转的快！");
    }

    @Override
    public void start() {
        log.info("启动快！可以自动启停！");
    }

}

@Slf4j
class CheapEngine implements Engine {

    @Override
    public void run() {
        log.info("转的慢！");
    }

    @Override
    public void start() {
        log.info("启动慢!");
    }

}