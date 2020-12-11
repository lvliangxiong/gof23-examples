package com.joey.learning.gof23.behavioral.iterator;

/**
 * 自定义的迭代器接口
 */
public interface Iterator<T> {
    void first(); // 将游标指向第一个元素

    T next(); // 将游标指向下一个元素

    boolean hasNext();// 判断是否存在下一个元素

    boolean isFirst();

    boolean isLast();

    T getCurrentObj();  // 获取当前游标指向的对象
}