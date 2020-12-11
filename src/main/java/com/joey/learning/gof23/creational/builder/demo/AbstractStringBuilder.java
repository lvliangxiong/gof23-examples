package com.joey.learning.gof23.creational.builder.demo;

import java.util.Arrays;

public class AbstractStringBuilder {
    protected char[] value;
    protected int count;

    public AbstractStringBuilder(int capacity) {
        count = 0;
        value = new char[capacity];
    }

    public AbstractStringBuilder append(char ch) {
        ensureCapacityInternal(count + 1); // 保证 value 的容量至少还能添加一个字符
        value[count++] = ch;
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        if (value.length < minimumCapacity)
            expandCapacity(minimumCapacity);
    }

    private void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity < 0) newCapacity = Integer.MAX_VALUE;
        if (newCapacity < minimumCapacity) newCapacity = minimumCapacity;
        if (minimumCapacity > 0) {
            value = Arrays.copyOf(value, newCapacity);
            return;
        }
        // overflow
        throw new OutOfMemoryError();
    }
}
