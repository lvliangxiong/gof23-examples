package com.joey.learning.gof23.creational.singleton;

import lombok.extern.slf4j.Slf4j;
import sun.awt.util.IdentityArrayList;

import java.util.Date;

/**
 * 枚举单例实现。（Effective Java 推荐）
 * 特点：
 * 1. JVM底层保证单例，线程安全
 * 2. 调用效率高
 * 3. 使用时进行初始化
 * 4. 可以防止反射和反序列化的漏洞
 */
public enum EnumSingleton {
    INSTANCE("Joey", new Date()); // 枚举元素，本身就是单例对象

    private String name;
    private Date date;

    EnumSingleton(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
