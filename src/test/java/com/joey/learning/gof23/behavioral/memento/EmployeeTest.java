package com.joey.learning.gof23.behavioral.memento;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class EmployeeTest {

    @Test
    void memento() {
        CareTake ct = new CareTake();
        Employee emp = new Employee("Joey", 18, 20000, "I love Evelyn.");
        log.info("{}", emp);

        // 进行备忘录操作
        ct.setMemento(emp.memento());

        emp.setAge(20);
        emp.setSalary(200000);
        emp.setMsg("We married.");
        log.info("{}", emp);

        emp.recover(ct.getMemento());
        log.info("{}", emp);
    }
}