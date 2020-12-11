package com.joey.learning.gof23.structural.adapter;

/**
 * Adapter 适配器，需要实现 USB 接口，因为它需要和电脑进行连接。
 * 另外它还要能和被适配器 Adaptee 连接，可以使用继承或者组合的方式实现
 */
public class Adapter implements USB {
    // 组合方式，比继承用得更多，因为 Java 有单继承的限制
    private PS2Keyboard ps2Keyboard;

    public Adapter(PS2Keyboard ps2Keyboard) {
        this.ps2Keyboard = ps2Keyboard;
    }

    @Override
    public void handle() {
        ps2Keyboard.type();
    }
}
