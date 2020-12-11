package com.joey.learning.gof23.behavioral.mediator;

public class Market implements Department {
    private Mediator m;  //持有中介者(总经理)的引用

    public Market(Mediator m) {
        this.m = m;
        m.register("market", this);
    }

    @Override
    public void outAction() {
        System.out.println("接到很多项目，需要赶紧研发...");
        m.command("development");
    }

    @Override
    public void selfAction() {
        System.out.println("跑去接项目！");
    }
}
