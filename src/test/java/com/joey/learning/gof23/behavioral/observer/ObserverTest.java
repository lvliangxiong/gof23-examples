package com.joey.learning.gof23.behavioral.observer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ObserverTest {

    @Test
    void update() {
        // 目标对象
        ConcreteSubject subject = new ConcreteSubject();

        // 创建多个观察者
        ConcreteObserver obs1 = new ConcreteObserver();
        ConcreteObserver obs2 = new ConcreteObserver();
        ConcreteObserver obs3 = new ConcreteObserver();

        // 将这三个观察者添加到 subject 对象的观察者容器中
        subject.addObserver(obs1);
        subject.addObserver(obs2);
        subject.addObserver(obs3);

        // 改变 subject 的状态
        subject.setState(3000);

        subject.deleteObserver(obs2);

        // 改变 subject 的状态
        subject.setState(30);
    }
}