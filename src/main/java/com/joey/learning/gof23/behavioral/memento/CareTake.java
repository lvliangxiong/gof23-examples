package com.joey.learning.gof23.behavioral.memento;

public class CareTake {
    // 如果存在许多备忘点，将此改成一个容器即可，另外还可以将此对象序列化、持久化
    private EmployeeMemento memento;

    public EmployeeMemento getMemento() {
        return memento;
    }

    public void setMemento(EmployeeMemento memento) {
        this.memento = memento;
    }
}
