package com.joey.learning.gof23.structural.adapter;

/**
 * 笔记本电脑
 */
public class Laptop {
    /**
     * 需要的是 USB 接口的键盘
     *
     * @param usbKeyboard
     */
    public void type(USB usbKeyboard) {
        usbKeyboard.handle();
    }
}
