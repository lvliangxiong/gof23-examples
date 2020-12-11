package com.joey.learning.gof23.behavioral.observer;

import java.util.Observable;

public class ConcreteSubject extends Observable {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if (this.state != state) {
            this.state = state;
            setChanged();
            // 主题对象(目标对象) 值发生了变化，请通知所有的观察者
            notifyObservers(this.state);
        }
    }
}
