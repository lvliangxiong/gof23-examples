package com.joey.learning.gof23.behavioral.templatemethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BankService {

    public void queue() {
        log.info("取号排队");
    }

    /**
     * 办理具体的业务，依赖子类来实现。
     */
    public abstract void service();


    public void feedback() {
        log.info("反馈评分");
    }

    /**
     * A template method defines an algorithm in terms of abstract operations that subclasses override to
     * provide concrete behavior.
     */
    public final void process() {
        this.queue();
        this.service();
        this.feedback();
    }
}
