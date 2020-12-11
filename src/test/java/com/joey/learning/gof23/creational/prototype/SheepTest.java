package com.joey.learning.gof23.creational.prototype;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;

@Slf4j
class SheepTest {

    @Test
    void testClone() throws CloneNotSupportedException {
        Date date = new Date(13145200000L);
        Sheep s1 = new Sheep("多利", date);
        Sheep s2 = (Sheep) s1.clone();

        log.info("{}", s1);
        log.info("{}", s2);

        log.info("{}", s1.getName());
        log.info("{}", s2.getName());
        log.info("{}", s1.getBirthday());
        log.info("{}", s2.getBirthday());

        date.setTime(52000001314L);
        log.info("{}", s1.getBirthday());
        log.info("{}", s2.getBirthday());
    }
}