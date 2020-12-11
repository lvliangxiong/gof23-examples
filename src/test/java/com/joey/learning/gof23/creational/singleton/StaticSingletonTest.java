package com.joey.learning.gof23.creational.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StaticSingletonTest {
    static StaticSingleton s1;
    static StaticSingleton s2;
    static Class clz;

    @Test
    @Order(1)
    void getInstance() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            s1 = StaticSingleton.getInstance();
        });

        Thread t2 = new Thread(() -> {
            s2 = StaticSingleton.getInstance();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Assertions.assertTrue(s1 == s2);
    }

    @Test
    @Order(2)
    void reflection() {
        // 测试反射破解单例
        try {
            clz = Class.forName("com.joey.learning.gof23.creational.singleton.StaticSingleton");
            Constructor<?> constructor = clz.getDeclaredConstructor();
            constructor.setAccessible(true);
            // 抛出的异常不会被捕获
            Assertions.assertThrows(InvocationTargetException.class, (Executable) constructor.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // e.printStackTrace();
        }
    }
}