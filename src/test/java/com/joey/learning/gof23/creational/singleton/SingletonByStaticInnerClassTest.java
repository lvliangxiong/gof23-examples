package com.joey.learning.gof23.creational.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SingletonByStaticInnerClassTest {
    static SingletonByStaticInnerClass instance;
    static SingletonByStaticInnerClass s1;
    static SingletonByStaticInnerClass s2;

    @Test
    @Order(1)
    void reflection() {
        try {
            Class<?> clz = Class.forName("com.joey.learning.gof23.creational.singleton.SingletonByStaticInnerClass");
            Constructor<?> constructor = clz.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance = (SingletonByStaticInnerClass) constructor.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // e.printStackTrace();
            log.warn(e.getCause().getMessage());
        }
    }

    @Test
    @Order(2)
    void getInstance() {
        s1 = SingletonByStaticInnerClass.getInstance();
        s2 = SingletonByStaticInnerClass.getInstance();
        Assertions.assertTrue(s1 == s2);
    }

}