package com.joey.learning.gof23.structural.adapter;

import org.junit.jupiter.api.Test;

class AdapterTest {

    @Test
    void input() {
        Laptop l = new Laptop();

        // 如果有 USB 键盘，那么我们就可以直接使用 USB 键盘输入
        l.type(new USBKeyboard());

        // 有些情况，我们只有 PS2Keyboard，因此需要一个 Adapter 来实现键盘的功能
        l.type(new Adapter(new PS2Keyboard()));
    }
}