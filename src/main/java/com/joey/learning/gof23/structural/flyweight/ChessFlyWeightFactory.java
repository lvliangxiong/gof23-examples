package com.joey.learning.gof23.structural.flyweight;


import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类，创建并管理享元对象
 */
public class ChessFlyWeightFactory {
    // 享元池，一般设计为键值对
    private static Map<String, Chess> map = new HashMap<>();

    public static Chess getChess(String color) {
        return map.computeIfAbsent(color, k -> new ConcreteChess(k));
    }
}