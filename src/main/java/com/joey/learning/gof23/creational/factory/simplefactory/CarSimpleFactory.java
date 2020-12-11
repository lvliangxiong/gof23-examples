package com.joey.learning.gof23.creational.factory.simplefactory;

/**
 * 简单工厂模式，也叫静态工厂模式，也就是工厂常使用静态方法，通过接收不同的参数来返回不同的对象实例。
 * 缺点：对增加新产品，不修改代码是无法扩展的，违背了 OCP 原则，但是依然被广泛使用。
 */
public class CarSimpleFactory {
    public static Car createCar(String type) {
        if ("Audi".equals(type)) {
            return new Audi();
        } else if ("Byd".equals(type)) {
            return new Byd();
        }
        return null;
    }

    public static Car createAudi() {
        return new Audi();
    }

    public static Car createByd() {
        return new Byd();
    }
}
