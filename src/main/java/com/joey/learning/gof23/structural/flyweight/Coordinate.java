package com.joey.learning.gof23.structural.flyweight;

import lombok.Getter;
import lombok.Setter;

/**
 * 外部状态 UnSharedConcreteFlyWeight
 */
@Getter
@Setter
public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}