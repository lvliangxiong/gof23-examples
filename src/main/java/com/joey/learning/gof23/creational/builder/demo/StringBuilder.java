package com.joey.learning.gof23.creational.builder.demo;

public class StringBuilder extends AbstractStringBuilder {
    public StringBuilder() {
        // 初始大小为 16
        super(16);
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}
