package com.joey.learning.gof23.structural.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * 不能用 interface，因为这里需要一个属性
 */
public abstract class Computer {
    // 声明为 protected，这样子类就能够直接使用
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    abstract void sale();
}

@Slf4j
class Laptop extends Computer {

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    void sale() {
        log.info("销售{}笔记本", brand.info());
    }
}

@Slf4j
class Desktop extends Computer {

    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    void sale() {
        log.info("销售{}台式机", brand.info());

    }
}