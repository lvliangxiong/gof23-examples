package com.joey.learning.gof23.creational.builder.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class StringBuilderTest {

    @Test
    void testToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append((char) ('a' + i));
        }
        log.info("{}", sb.toString());
    }
}