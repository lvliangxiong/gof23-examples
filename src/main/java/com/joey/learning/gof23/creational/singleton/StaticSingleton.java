package com.joey.learning.gof23.creational.singleton;

public class StaticSingleton {

    private static StaticSingleton instance = new StaticSingleton();

    private StaticSingleton() {
        // 只有类加载时，第一次调用构造方法是可以成功实例化的，后续的任何调用都会抛出异常
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    public static StaticSingleton getInstance() {
        return instance;
    }
}
