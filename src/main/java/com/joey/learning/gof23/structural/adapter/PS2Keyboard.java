package com.joey.learning.gof23.structural.adapter;

/**
 * Adaptee
 * 需要被适配的对象，即 PS2 接口的键盘无法与 USB 接口的电脑连接
 */
public class PS2Keyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("使用PS/2接口键盘输入");
    }
}
