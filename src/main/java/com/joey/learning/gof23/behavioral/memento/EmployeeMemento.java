package com.joey.learning.gof23.behavioral.memento;

import lombok.Data;

@Data
public class EmployeeMemento {
    private String name;
    private int age;
    private int salary;
    transient private String msg;

    public EmployeeMemento(Employee employee) {
        name = employee.getName();
        age = employee.getAge();
        salary = employee.getSalary();
        msg = employee.getMsg();
    }
}