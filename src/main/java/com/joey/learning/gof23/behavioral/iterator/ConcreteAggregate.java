package com.joey.learning.gof23.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的聚合类
 */
public class ConcreteAggregate<T> {
    private List<T> list = new ArrayList<T>();

    public void addObject(T t) {
        this.list.add(t);
    }

    public void removeObject(T t) {
        this.list.remove(t);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    // 获得迭代器
    public Iterator createIterator() {
        return new ConcreteIterator();
    }

    // 使用内部类定义迭代器，可以直接使用外部类的属性，并且专门为外部类服务
    private class ConcreteIterator implements Iterator<T> {
        private int cursor;  // 定义游标用于记录遍历时的位置

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public T getCurrentObj() {
            return list.get(cursor);
        }

        @Override
        public boolean hasNext() {
            if (cursor < list.size()) {
                return true;
            }
            return false;
        }

        @Override
        public boolean isFirst() {
            return cursor == 0 ? true : false;
        }

        @Override
        public boolean isLast() {
            return cursor == (list.size() - 1) ? true : false;
        }

        @Override
        public T next() {
            T t = null;
            if (cursor < list.size()) {
                t = getCurrentObj();
                cursor++;
            }
            return t;
        }
    }
}

