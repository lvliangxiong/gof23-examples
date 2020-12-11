package com.joey.learning.gof23.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Proxy Pattern 中的 RealSubject
 */
@Slf4j
public class RealStar implements Star {

    private String name;

    public RealStar(String name) {
        this.name = name;
    }

    /**
     * 工作
     */
    @Override
    public void work() {
        perform();
    }

    private void perform() {
        log.info("Real star {} is performing ...", name);
    }

    @Override
    public String toString() {
        return "RealStar{" +
                "name='" + name + '\'' +
                '}';
    }
}
