package com.joey.learning.gof23.behavioral.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 负责和具体的策略类交互：具体的算法和客户端调用分离了，使得算法可以独立于客户端独立地变化。
 * 如果使用 Spring 的依赖注入功能，还可以通过配置文件，动态的注入不同策略对象，动态的切换不同的算法。
 */
@Slf4j
public class PriceQuoting {
    // 当前采用的策略
    private Strategy strategy;

    // 可以通过构造器来注入
    public PriceQuoting(Strategy strategy) {
        this.strategy = strategy;
    }

    // 可以通过set方法来注入
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double price) {
        log.info("您该报价：{}", strategy.getPrice(price));
    }
}
