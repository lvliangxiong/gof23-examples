package com.joey.learning.gof23.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Joey
 * @version 1.0
 * @date 6/4/2020 2:10 PM
 */
@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private int age;
    private int salary;
    private String msg;

    /**
     * 备份
     *
     * @return
     */
    public EmployeeMemento memento() {
        return new EmployeeMemento(this);
    }

    /**
     * 恢复
     *
     * @param memento
     */
    public void recover(EmployeeMemento memento) {
        name = memento.getName();
        age = memento.getAge();
        salary = memento.getSalary();
        msg = memento.getMsg();
    }
}
