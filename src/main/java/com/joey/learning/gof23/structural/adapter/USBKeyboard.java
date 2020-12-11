package com.joey.learning.gof23.structural.adapter;

/**
 * 实现了USB接口的USB键盘
 */
public class USBKeyboard implements USB, Keyboard {
    @Override
    public void type() {
        System.out.println("使用USB接口的键盘输入");
    }

    @Override
    public void handle() {
        type();
    }
}