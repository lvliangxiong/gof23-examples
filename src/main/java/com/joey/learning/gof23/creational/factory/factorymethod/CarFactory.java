package com.joey.learning.gof23.creational.factory.factorymethod;

/**
 * 工厂方法模式，添加新产品时，不需要修改已有的类，但是会比简单工厂模式创建更多的类。
 * <p>为创建对象定义了一个接口，用于创建对象，然后为每种 Car 相应地实现其工厂类。</p>
 */
public interface CarFactory {
    Car createCar();
}
