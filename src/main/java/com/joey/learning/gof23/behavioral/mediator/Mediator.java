package com.joey.learning.gof23.behavioral.mediator;

public interface Mediator {

    void register(String dname, Department d);

    void command(String dname);
}