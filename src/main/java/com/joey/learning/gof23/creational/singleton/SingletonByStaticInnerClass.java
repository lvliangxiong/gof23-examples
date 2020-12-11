package com.joey.learning.gof23.creational.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 静态内部类实现单例模式。
 * 特点：
 * 1. 线程安全
 * 2. 调用效率高
 * 3. 懒加载
 * 4. 使用反射调用私有构造方法（无论 instance 是否被初始化）均会抛出异常
 */
public class SingletonByStaticInnerClass {

    private SingletonByStaticInnerClass() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("wrong");
        }
    }

    public static SingletonByStaticInnerClass getInstance() {
        /* 只有当调用此函数的时候，才会去加载内部类（在类加载过程中会实例化外部类的对象）,
         * 而且由于类加载过程时天然线程安全的，所以同时实现了懒加载、线程安全和调用效率高。*/
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {
        // final 可有可无，根据需要修改
        private static final SingletonByStaticInnerClass instance = new SingletonByStaticInnerClass();
    }

}
