package com.joey.learning.gof23.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sheep implements Cloneable {
    private String name;
    private Date birthday;

    /**
     * clone 方法是 Object 的方法，Cloneable 是空接口，即标记接口，重写的是 Object 中的 clone 方法，该方法是一个 protect 的
     * native 方法，一般来说，我们需要进行重写，便于客户端调用（访问权限的问题），或者实现深克隆。
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 直接返回 obj 会出现浅克隆的问题，因为birthday属性是一个引用类型，内部存放的是地址
        Object obj = super.clone();

        // 将属性也克隆一份，实现 Deep Clone
        Sheep sheep = (Sheep) obj;
        sheep.birthday = (Date) this.birthday.clone();

        return obj;
    }
}
