package com.joey.learning.gof23.behavioral.mediator;

public class Financial implements Department {
    private Mediator m;  //持有中介者(总经理)的引用

    public Financial(Mediator m) {
        this.m = m;
        m.register("financial", this);
    }

    @Override
    public void outAction() {
        System.out.println("没钱了，需要扩展项目...");
        m.command("market");
    }

    @Override
    public void selfAction() {
        System.out.println("拨款 ...");
    }
}
