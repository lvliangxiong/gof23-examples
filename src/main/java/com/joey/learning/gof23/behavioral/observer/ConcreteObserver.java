package com.joey.learning.gof23.behavioral.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

@Slf4j
class ConcreteObserver implements Observer {
    private int myState;

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }

    @Override
    public void update(Observable o, Object arg) {
        myState = (int) arg;
        log.info("观察者 {} 目标值已更新为：{}", hashCode(), myState);
    }
}
