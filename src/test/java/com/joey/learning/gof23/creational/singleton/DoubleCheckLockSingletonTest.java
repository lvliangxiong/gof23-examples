package com.joey.learning.gof23.creational.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.joey.utils.serialization.SerializationUtils.read;
import static com.joey.utils.serialization.SerializationUtils.save;


/**
 * @author Joey
 * @version 1.0
 * @date 6/4/2020 2:16 PM
 */
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoubleCheckLockSingletonTest {
    static DoubleCheckLockSingleton s1;
    static DoubleCheckLockSingleton s2;
    static Class clz;

    private long start;
    private long end;

    @Test
    @Order(1)
    void getInstance() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            s1 = DoubleCheckLockSingleton.getInstance();
        });

        Thread t2 = new Thread(() -> {
            s2 = DoubleCheckLockSingleton.getInstance();
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
            clz = Class.forName("com.joey.learning.gof23.creational.singleton.DoubleCheckLockSingleton");
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
            log.warn(e.getCause().getMessage());
        }
    }

    @Test
    @Order(3)
    void deserialization() {
        // 测试反序列化破解单例
        File file = new File("src/test/resources/test");
        save(file, s1);
        Object obj = read(file);
        Assertions.assertTrue(s1 == obj);
        file.delete();
    }

    @Test
    @Order(4)
    void cloneTest() {
        try {
            Method clone = Object.class.getDeclaredMethod("clone");
            clone.setAccessible(true);
            Object s1Clone = clone.invoke(s1);
            Assertions.assertTrue(s1Clone == s1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}