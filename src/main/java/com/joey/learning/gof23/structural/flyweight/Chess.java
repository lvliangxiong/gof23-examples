package com.joey.learning.gof23.structural.flyweight;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象享元类，这里设计成了一个接口
 * 声明公共方法，这些方法可以向外界提供对象的内部状态，设置外部对象
 */
public interface Chess {
    // 向外界提供的获取颜色的方法，颜色是一个内部对象
    String getColor();

    void display(Coordinate c);
}

/**
 * 具体享元类
 */
@Slf4j
class ConcreteChess implements Chess {

    // 为内部状态提供了属性进行储存
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    // 向外界提供的 设置（操控）外部状态的方法
    @Override
    public void display(Coordinate c) {
        log.info("棋子颜色： {}", color);
        log.info("棋子位置： {}\t{}", c.getX(), c.getY());
    }

    @Override
    public String getColor() {
        return color;
    }
}