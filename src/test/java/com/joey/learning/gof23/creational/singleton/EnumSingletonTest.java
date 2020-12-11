package com.joey.learning.gof23.creational.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @author Joey
 * @version 1.0
 * @date 6/4/2020 2:03 PM
 */
@Slf4j
class EnumSingletonTest {

    @Test
    void getInstance() throws InterruptedException {
        log.info("start");

        EnumSingleton instance = EnumSingleton.getInstance();
        Assertions.assertTrue(instance == EnumSingleton.INSTANCE);
    }

    @Test
    void reflection() {
        try {
            Class<?> clz = Class.forName("com.joey.learning.gof23.creational.singleton.EnumSingleton");
            // 输出所有 constructor 的参数
            // 发现除了我们显式声明的两个参数之外，JVM 还添加了一个 String 和 int，猜测应该就是枚举类型的 name 和 ordinal
            for (Constructor<?> declaredConstructor : clz.getDeclaredConstructors()) {
                log.info("{}", declaredConstructor.getName());
                for (Class<?> parameterType : declaredConstructor.getParameterTypes()) {
                    log.info("{}", parameterType.getTypeName());
                }
            }
            Constructor<?> constructor = clz.getDeclaredConstructor(String.class, int.class, String.class, Date.class);
            constructor.setAccessible(true);
            EnumSingleton instance = (EnumSingleton) constructor
                    .newInstance("AnotherInstance", 1, "Evelyn", new Date());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // JVM 要求不能反射创建枚举的实例，因此此单例实现是十分安全的
            log.warn(e.getMessage());
        }

    }
}